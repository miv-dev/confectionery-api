package entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.Products

class ProductEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ProductEntity>(Products)

    var name by Products.name
    var description by Products.description
    var width by Products.width
    var height by Products.height
}