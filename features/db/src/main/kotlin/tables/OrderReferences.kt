package tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object OrderReferences: IntIdTable("order_references") {
    val order = reference("order_id", Orders, onDelete = ReferenceOption.CASCADE)
    val url = varchar("url", 255)
}