import io.ktor.client.plugins.*

sealed class Failure(val exception: Throwable) {
    class HttpErrorInternalServer(exception: ServerResponseException) : Failure(exception)
    class HttpErrorRedirectResponseException(exception: RedirectResponseException) : Failure(exception)
    class HttpErrorBadRequest(exception: ClientRequestException) : Failure(exception)
    class HttpErrorUnauthorized(exception: ClientRequestException) : Failure(exception)
    class HttpErrorForbidden(exception: ClientRequestException) : Failure(exception)
    class HttpErrorNotFound(exception: ClientRequestException) : Failure(exception)
    class HttpErrorUnreachableServer(exception: Throwable) : Failure(exception)
    class HttpError(exception: Throwable) : Failure(exception)
    class GenericError(exception: Throwable) : Failure(exception)
}