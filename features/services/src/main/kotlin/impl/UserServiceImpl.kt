package impl

import UserRepository
import UserService
import user.User

class UserServiceImpl(
    private val userRepo: UserRepository
) : UserService {
    override suspend fun getUserByUsername(username: String): User? {
        return userRepo.findByUsername(username)
    }
}