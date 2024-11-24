package tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Products: IntIdTable("products") {
    val name = varchar("name", 252)
    val description = text("description").nullable()
    val width = decimal("width").nullable().transform({ it?.toDouble() }, { it?.toBigDecimal() })
    val height = decimal("height").nullable().transform({ it?.toDouble() }, { it?.toBigDecimal() })
}