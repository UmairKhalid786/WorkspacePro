package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    @SerialName("offset") var offset: String? = null,
    @SerialName("description") var description: String? = null
)