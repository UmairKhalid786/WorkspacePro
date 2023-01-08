import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

fun <T> Flow<T>.toMutableStateFlow() = this as? MutableStateFlow<T>