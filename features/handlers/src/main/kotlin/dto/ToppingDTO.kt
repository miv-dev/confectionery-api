package dto

import serializers.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class ToppingDTO(
    val id: Int,
    val article: String,
    val type: ToppingTypeDTO,
    val name: String,
    val quantity: Int?,
    val unit: String?,
    val purchasePrice: Double?,
    val supplier: SupplierDTO?,
    val deliveryDuration: Int?,
    @Serializable(with = LocalDateSerializer::class)
    val shelfLife: LocalDate?
)

