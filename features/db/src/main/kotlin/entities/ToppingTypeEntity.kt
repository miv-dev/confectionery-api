package entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.ToppingTypes
import topping.ToppingType

class ToppingTypeEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ToppingTypeEntity>(ToppingTypes)

    var name by ToppingTypes.name

    fun toModel() = ToppingType(id.value, name)

}