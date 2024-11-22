package impl

import AuthService
import UserRepository
import user.Role
import user.User
import java.util.*

class AuthServiceImpl(
    private val userRepo: UserRepository
) : AuthService {
    override suspend fun authenticate(username: String, password: String): User? {
        val user = userRepo.findByUsername(username)
        return if (user?.password == password) user else null
    }


    override suspend fun register(username: String, password: String, fullName: String): User {
        val user = User(
            id = UUID.randomUUID(),
            role = Role.CUSTOMER,
            username = username,
            password = password,
            fullName = fullName
        )

        return userRepo.create(user)
    }
}