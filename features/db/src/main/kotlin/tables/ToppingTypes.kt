package tables

import org.jetbrains.exposed.dao.id.IntIdTable

object ToppingTypes: IntIdTable("topping_types") {
    val name = varchar("name", 50)
}
