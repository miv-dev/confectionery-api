import user.User

interface AuthService {
    suspend fun authenticate(username: String, password: String): User?

    suspend fun register(username: String, password: String, fullName: String): User
}