import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

actual abstract class ViewModel {
    private var hasCleared = false

    actual val viewModelScope: CoroutineScope by lazy {
        val result = CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

        if (hasCleared)
            closeWithRuntimeException(result)

        return@lazy result
    }

    protected actual open fun onCleared() {}

    /**
     * Closes the [viewModelScope] and cancels all its coroutines.
     * Should be called from main thread.
     */
    fun clear() {
        hasCleared = true
        closeWithRuntimeException(viewModelScope)
        onCleared()
    }

    companion object {
        private fun closeWithRuntimeException(obj: Any?) {
            if (obj is Closeable) {
                try {
                    obj.close()
                } catch (e: Exception) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}


internal class CloseableCoroutineScope(scope: CoroutineContext) : Closeable, CoroutineScope {
    override val coroutineContext: CoroutineContext = scope
    override fun close() {
        coroutineContext.cancel()
    }
}