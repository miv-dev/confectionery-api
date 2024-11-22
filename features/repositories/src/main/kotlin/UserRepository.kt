import user.User
import java.util.*

interface UserRepository {
    //CREATE
    suspend fun create(user: User): User

    //READ
    suspend fun findByUsername(username: String): User?
    suspend fun list(): List<User>
    suspend fun get(id: UUID): User?

    //UPDATE
    suspend fun update(user: User): User?

    //DELETE
    suspend fun delete(id: UUID): Boolean
}