package entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import supplier.Supplier
import tables.Suppliers

class SupplierEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<SupplierEntity>(Suppliers)

    var name by Suppliers.name
    var address by Suppliers.address
    var deliveryTime by Suppliers.deliveryTime

    fun toModel() = Supplier(
        id = id.value,
        name = name,
        address = address,
        deliveryTime = deliveryTime
    )
}