
package entities

import order.Order
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.OrderReferences
import tables.Orders
import java.util.*

class OrderEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<OrderEntity>(Orders)

    var orderDate by Orders.orderDate
    var status by Orders.status
    var customer by UserEntity referencedOn Orders.customer
    var total by Orders.total
    var plannedCompletionDate by Orders.plannedCompletionDate
    var manager by UserEntity optionalReferencedOn Orders.manager
    val references by OrderReferenceEntity referrersOn OrderReferences.order

    fun toModel() = Order(
        id = id.value,
        number = id.value.toString().substring(0, 3),
        orderDate = orderDate,
        status = status,
        customer = customer.toModel(),
        total = total,
        plannedCompletionDate = plannedCompletionDate,
        manager = manager?.toModel()
    )
}