package user

import java.util.UUID

data class User(
    val id: UUID,
    val role: Role,
    val fullName: String,
    val username: String,
    val password: String
)