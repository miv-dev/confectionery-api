package impl

import AuthHandler
import AuthService
import Session
import UserService
import dto.LoginRequest
import dto.RegisterRequest
import exceptions.AppException
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import mapper.toDto
import user.User

class AuthHandlerImpl(
    private val authService: AuthService,
    private val userService: UserService
) : AuthHandler {
    override suspend fun login(call: ApplicationCall) {
        val data = call.receive<LoginRequest>()

        val user = authService.authenticate(data.username, data.password)
            ?: throw AppException.InvalidCredentials("Invalid credentials")

        call.sessions.set(Session(user.username, user.role))

        call.respond(user.toDto())
    }

    private fun passwordIsValid(password: String, username: String): Boolean {
        if (password.length !in 5..20) return false

        if (password.contains(username, ignoreCase = true)) return false

        if (!password.any { it.isUpperCase() }) return false

        if (!password.any { it.isLowerCase() }) return false

        return true
    }

    override suspend fun register(call: ApplicationCall) {
        val data = call.receive<RegisterRequest>()

        if (userService.getUserByUsername(data.username) != null) {
            throw AppException.UserAlreadyExists("User already exists")
        }

        if (!passwordIsValid(data.password, data.username)) {
            throw AppException.PasswordNotValid("Password is not valid")
        }

        val user = authService.register(data.username, data.password, data.fullName)

        call.sessions.set(Session(user.username, user.role))
        call.respond(user.toDto())
    }

}