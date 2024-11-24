package dto

import kotlinx.serialization.Serializable

@Serializable
data class ToppingTypeDTO(
    val id: Int,
    val name: String
)