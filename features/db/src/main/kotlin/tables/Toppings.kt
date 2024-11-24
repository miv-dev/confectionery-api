package tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.date

object Toppings : IntIdTable("toppings") {
    val article = varchar("article", 255)
    val type = reference("type_id", ToppingTypes, onDelete = ReferenceOption.CASCADE)
    val name = varchar("name", 255)
    val quantity = integer("quantity").nullable()
    val unit = varchar("unit", 255).nullable()
    val purchasePrice = decimal("purchase_price", 10, 2).nullable().transform({ it?.toDouble() }, { it?.toBigDecimal() })
    val supplier = optReference("supplier_id", Suppliers, onDelete = ReferenceOption.SET_NULL)
    val deliveryDuration = integer("delivery_duration").nullable()
    val shelfLife = date("shelf_life").nullable()
}