package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    @SerialName("large") var large: String? = null,
    @SerialName("medium") var medium: String? = null,
    @SerialName("thumbnail") var thumbnail: String? = null
)