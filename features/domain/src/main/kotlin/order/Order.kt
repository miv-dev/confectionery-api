package order

import java.time.LocalDate
import java.util.UUID

data class Order(
    val id: UUID,
    val number: String,
    val orderDate: LocalDate,
    val status: Int,
    val customer: user.User,
    val total: Double,
    val plannedCompletionDate: LocalDate?,
    val manager: user.User?
)
