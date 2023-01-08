package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName("latitude") var latitude: String? = null,
    @SerialName("longitude") var longitude: String? = null
)