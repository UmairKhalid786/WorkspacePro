import io.ktor.client.*
import io.ktor.client.engine.cio.*
import java.util.concurrent.TimeUnit

actual class Platform actual constructor() {
    actual val platform: String = "JVM"
    actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(CIO) {
        config(this)

        engine {
            maxConnectionsCount = 1000
            endpoint {
                // this: EndpointConfig
                maxConnectionsPerRoute = 100
                pipelineMaxSize = 20
                keepAliveTime = 5000
                connectTimeout = 5000
                connectAttempts = 5
            }
        }
    }
}