package tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.date

object Orders: UUIDTable("orders") {
    val orderDate = date("order_date")
    val status = integer("status").default(0)
    val customer = reference("customer_id", Users, onDelete = ReferenceOption.CASCADE)
    val total = decimal("total", 10, 2).transform({ it.toDouble() }, { it.toBigDecimal() })
    val plannedCompletionDate = date("planned_completion_date").nullable()
    val manager = reference("manager_id", Users, onDelete = ReferenceOption.SET_NULL).nullable()
}
