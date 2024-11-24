package entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.Tools
import tool.Tool

class ToolEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ToolEntity>(Tools)

    var name by Tools.name
    var description by Tools.description
    var supplier by SupplierEntity referencedOn Tools.supplier
    var wear by Tools.wear
    var type by ToolTypeEntity referencedOn Tools.type
    var purchaseDate by Tools.purchaseDate
    var quantity by Tools.quantity

    fun toModel() = Tool(
        id = id.value,
        name = name,
        description = description,
        supplier = supplier.toModel(),
        wear = wear,
        type = type.toModel(),
        purchaseDate = purchaseDate,
        quantity = quantity
    )
}