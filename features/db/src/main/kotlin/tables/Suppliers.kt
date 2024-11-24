package tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Suppliers: IntIdTable("suppliers") {
    val name = varchar("name", 255)
    val address = text("address")
    val deliveryTime = integer("delivery_time")
}

