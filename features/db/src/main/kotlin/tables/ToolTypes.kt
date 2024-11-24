package tables

import org.jetbrains.exposed.dao.id.IntIdTable

object ToolTypes: IntIdTable("tool_types") {
    val name = varchar("name", 255)
}

