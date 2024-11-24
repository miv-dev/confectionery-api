package tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.date
import tool.Wear

object Tools: IntIdTable("tools") {
    val name = varchar("name", 255)
    val description = text("description")
    val supplier = reference("supplier_id", Suppliers, onDelete = ReferenceOption.CASCADE)
    val wear = enumeration<Wear>("wear")
    val type = reference("type_id", ToolTypes, onDelete = ReferenceOption.CASCADE)
    val purchaseDate = date("purchase_date")
    val quantity = integer("quantity")
}
