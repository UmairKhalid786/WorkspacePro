package users.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Id (

  @SerialName("name"  ) var name  : String? = null,
  @SerialName("value" ) var value : String? = null

)