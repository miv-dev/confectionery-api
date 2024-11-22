package exceptions

import io.ktor.http.*

sealed class AppException(
    override val message: String,
    val code: HttpStatusCode
) : RuntimeException(message) {

    data class NotFound(val msg: String) : AppException(msg, HttpStatusCode.NotFound) // code 404
    data class BadRequest(val msg: String) : AppException(msg, HttpStatusCode.BadRequest) // code 400
    data class Unauthorized(val msg: String) : AppException(msg, HttpStatusCode.Unauthorized) // code 401
    data class InvalidCredentials(val msg: String) : AppException(msg, HttpStatusCode.Unauthorized) // code 401
    data class PasswordNotValid(val msg: String) : AppException(msg, HttpStatusCode.BadRequest) // code 400
    data class UserAlreadyExists(val msg: String) : AppException(msg, HttpStatusCode.BadRequest) // code 400

}