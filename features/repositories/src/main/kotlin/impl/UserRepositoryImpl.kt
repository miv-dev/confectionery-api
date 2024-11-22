package impl

import UserRepository
import entities.UserEntity
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import tables.Users
import user.User
import java.util.*

class UserRepositoryImpl : UserRepository {
    override suspend fun create(user: User): User = newSuspendedTransaction {
        UserEntity.new(UUID.randomUUID()) {
            username = user.username
            password = user.password
            fullName = user.fullName
            role = user.role
        }.toModel()
    }

    override suspend fun findByUsername(username: String): User? = newSuspendedTransaction {
        UserEntity.find { Users.username eq username }.firstOrNull()?.toModel()
    }

    override suspend fun list(): List<User> = newSuspendedTransaction {
        UserEntity.all().map(UserEntity::toModel)
    }

    override suspend fun get(id: UUID): User? = newSuspendedTransaction {
        UserEntity.findById(id)?.toModel()
    }

    override suspend fun update(user: User): User? = newSuspendedTransaction {
        UserEntity.findByIdAndUpdate(user.id) {
            it.username = user.username
            it.password = user.password
            it.fullName = user.fullName
            it.role = user.role
        }?.toModel()
    }


    override suspend fun delete(id: UUID): Boolean {
        return transaction {
            UserEntity.findById(id)?.delete()?.let { true } ?: false
        }
    }

}