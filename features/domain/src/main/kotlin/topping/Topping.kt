package topping

import supplier.Supplier
import java.time.LocalDate

data class Topping(
    val id: Int,
    val article: String,
    val type: ToppingType,
    val name: String,
    val quantity: Int?,
    val unit: String?,
    val purchasePrice: Double?,
    val supplier: Supplier?,
    val deliveryDuration: Int?,
    val shelfLife: LocalDate?
)

