package entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.ToolTypes

class ToolTypeEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ToolTypeEntity>(ToolTypes)

    var name by ToolTypes.name

    fun toModel() = tool.ToolType(
        id = id.value,
        name = name
    )
}