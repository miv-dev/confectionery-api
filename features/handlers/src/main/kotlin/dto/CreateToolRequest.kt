package dto

import com.miv.utils.LocalDateSerializer
import kotlinx.serialization.Serializable
import tool.Wear
import java.time.LocalDate

@Serializable
data class CreateToolRequest(
    val name: String,
    val description: String,
    val supplierId: Int,
    val wear: Wear,
    val typeId: Int,
    @Serializable(with = LocalDateSerializer::class)
    val purchaseDate: LocalDate,
    val quantity: Int
)
