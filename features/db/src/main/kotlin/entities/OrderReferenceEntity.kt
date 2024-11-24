package entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.OrderReferences

class OrderReferenceEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<OrderReferenceEntity>(OrderReferences)

    var order by OrderEntity referencedOn OrderReferences.order
    var url by OrderReferences.url
}