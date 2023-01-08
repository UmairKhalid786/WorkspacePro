package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name (

  @SerialName("title" ) var title : String? = null,
  @SerialName("first" ) var first : String? = null,
  @SerialName("last"  ) var last  : String? = null

)