package order

import user.User
import java.time.LocalDate
import java.util.UUID

data class Order(
    val id: UUID,
    val number: String,
    val orderDate: LocalDate,
    val status: OrderStatus,
    val customer: User,
    val total: Double,
    val plannedCompletionDate: LocalDate?,
    val manager: User?
)
