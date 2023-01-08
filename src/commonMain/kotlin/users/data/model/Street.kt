package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Street(
    @SerialName("number") var number: Int? = null,
    @SerialName("name") var name: String? = null
)