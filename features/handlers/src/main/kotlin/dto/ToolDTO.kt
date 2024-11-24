package dto

import serializers.LocalDateSerializer
import kotlinx.serialization.Serializable
import tool.Wear
import java.time.LocalDate

@Serializable
data class ToolDTO(
    val id: Int,
    val name: String,
    val description: String,
    val supplier: SupplierDTO,
    val wear: Wear,
    val type: ToolTypeDTO,
    @Serializable(with = LocalDateSerializer::class)
    val purchaseDate: LocalDate,
    val quantity: Int,
)

