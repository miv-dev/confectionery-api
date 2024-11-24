package dto

import kotlinx.serialization.Serializable

@Serializable
data class SupplierDTO(
    val id: Int,
    val name: String,
    val address: String,
    val deliveryTime: Int
)