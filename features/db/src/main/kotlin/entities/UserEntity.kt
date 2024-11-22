package entities

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import tables.Users
import user.User
import java.util.*

class UserEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<UserEntity>(Users)

    var username by Users.username
    var password by Users.password
    var role by Users.role
    var fullName by Users.fullName

    fun toModel() = User(
        id = id.value,
        username = username,
        password = password,
        fullName = fullName,
        role = role
    )
}