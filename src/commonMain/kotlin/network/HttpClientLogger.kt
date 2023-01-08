package network

private const val TAG = "HttpClientLogger"

public object HttpClientLogger : io.ktor.client.plugins.logging.Logger {
    override fun log(message: String) {
        println(message)
    }
}
