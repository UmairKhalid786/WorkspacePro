package network

import Failure
import Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


const val USERS_API = "https://randomuser.me/api/"

object NetworkClient {
    val client by lazy { buildClient() }
    suspend inline fun <reified T> safeGet(url: String): Resource<T> = try {
        client.get(url).toResponse()
    } catch (e: Exception) {
        if (e.message?.contains("unable to resolve host", true) == true) {
            Resource.error(Failure.HttpErrorUnreachableServer(e))
        } else {
            Resource.error(Failure.GenericError(e))
        }
    } catch (e: Throwable) {
        Resource.error(Failure.HttpErrorUnreachableServer(e))
    }
}

internal fun buildClient() = HttpClient {
    val nonStrictJson = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    install(ContentNegotiation) {
        json(nonStrictJson)
    }

    install(Logging) {
        logger = HttpClientLogger
        level = LogLevel.ALL
    }
}


suspend inline fun <reified T> HttpResponse.toResponse(): Resource<T> {
    return when (status.value) {
        in 200..226 -> Resource.success(body())

        in 300..399 -> Resource.error(
            Failure.HttpErrorRedirectResponseException(
                RedirectResponseException(this, "Redirect response exception.")
            )
        )
        in 400..499 -> Resource.error(
            Failure.HttpErrorRedirectResponseException(
                RedirectResponseException(this, "Redirect response exception.")
            )
        )
        400 -> Resource.error(
            Failure.HttpErrorBadRequest(
                ClientRequestException(this, "Bad Request response exception.")
            )
        )
        401 -> Resource.error(
            Failure.HttpErrorUnauthorized(
                ClientRequestException(this, "Bad Request response exception.")
            )
        )
        403 -> Resource.error(
            Failure.HttpErrorForbidden(
                ClientRequestException(this, "Forbidden Exception due to roles.")
            )
        )
        404 -> Resource.error(
            Failure.HttpErrorNotFound(
                ClientRequestException(this, "End point not found.")
            )
        )
        in 500..599 -> Resource.error(
            Failure.HttpErrorInternalServer(
                ServerResponseException(this, "Internal server error.")
            )
        )
        else -> {
            Resource.error(
                Failure.HttpErrorInternalServer(
                    ServerResponseException(this, "Internal server error.")
                )
            )
        }
    }
}