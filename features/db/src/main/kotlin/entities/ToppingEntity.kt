package entities

import topping.Topping
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.Toppings

class ToppingEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ToppingEntity>(Toppings)

    var article by Toppings.article
    var name by Toppings.name
    var type by ToppingTypeEntity referencedOn Toppings.type
    var quantity by Toppings.quantity
    var unit by Toppings.unit
    var purchasePrice by Toppings.purchasePrice
    var supplier by SupplierEntity optionalReferencedOn  Toppings.supplier
    var deliveryDuration by Toppings.deliveryDuration
    var shelfLife by Toppings.shelfLife


    fun toModel() = Topping(
        id = id.value,
        article = article,
        name = name,
        type = type.toModel(),
        quantity = quantity,
        unit = unit,
        purchasePrice = purchasePrice,
        supplier = supplier?.toModel(),
        deliveryDuration = deliveryDuration,
        shelfLife = shelfLife
    )
}
