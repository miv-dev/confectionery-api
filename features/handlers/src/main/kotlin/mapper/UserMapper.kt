package mapper

import dto.UserDTO
import user.User

fun User.toDto() = UserDTO(
    id = id,
    username = username,
    fullName = fullName,
    role = role
)

fun UserDTO.toDomain() = User(
    id = id,
    username = username,
    fullName = fullName,
    role = role,
    password = ""
)