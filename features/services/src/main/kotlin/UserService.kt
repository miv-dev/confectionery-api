import user.User

interface UserService {

    suspend fun getUserByUsername(username: String): User?

}