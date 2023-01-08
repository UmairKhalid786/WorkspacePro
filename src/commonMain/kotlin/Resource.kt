
data class Resource<out T>(val status: Status, val  data: T? = null, val message: String? = null, val error: Failure? = null) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        DEFAULT,
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(failure: Failure): Resource<T> {
            return Resource(Status.ERROR, null, failure.exception.message ?: "Something went wrong", failure)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> default(): Resource<T> {
            return Resource(Status.DEFAULT, null, null)
        }
    }
}