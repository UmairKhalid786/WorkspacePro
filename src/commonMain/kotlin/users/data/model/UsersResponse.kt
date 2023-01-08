package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    @SerialName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerialName("info") var info: Info? = Info()
)