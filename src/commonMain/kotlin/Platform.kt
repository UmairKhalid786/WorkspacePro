import io.ktor.client.*

expect class Platform() {
    val platform: String
    fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
}