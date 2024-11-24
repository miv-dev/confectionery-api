package dto

import kotlinx.serialization.Serializable

@Serializable
data class ToolTypeDTO(
    val id: Int,
    val name: String
)