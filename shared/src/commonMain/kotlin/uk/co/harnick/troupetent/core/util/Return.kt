package uk.co.harnick.troupetent.core.util

sealed interface Return<T> {
    data class Success<T>(val data: T? = null) : Return<T>

    sealed class InProgress<T>(val status: String?, val progress: Float?) : Return<T> {
        class Fetching<T>(status: String, progress: Float? = null) : InProgress<T>(status, progress)
        class Loading<T>(status: String, progress: Float? = null) : InProgress<T>(status, progress)
        class Saving<T>(progress: Float? = null) : InProgress<T>(null, progress)
        class Deleting<T>(progress: Float? = null) : InProgress<T>(null, progress)
    }

    data class Error<T>(val reason: String?, val data: T? = null) : Return<T>
}
