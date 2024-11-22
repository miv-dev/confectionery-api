package tables

import org.jetbrains.exposed.dao.id.UUIDTable
import user.Role

object Users: UUIDTable("users") {
    val username = varchar("username", 255).uniqueIndex()
    val password = varchar("password", 255)
    val fullName = varchar("full_name", 255)
    val role = enumeration<Role>("role")
}
