package dto

import serializers.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class ToppingRequest(
    val article: String,
    val typeId: Int,
    val name: String,
    val quantity: Int?,
    val unit: String?,
    val purchasePrice: Double?,
    val supplierId: Int?,
    val deliveryDuration: Int?,
    @Serializable(with = LocalDateSerializer::class)
    val shelfLife: LocalDate?
)
