package dto

import kotlinx.serialization.Serializable
import serializers.UUIDSerializer
import user.Role
import java.util.UUID

@Serializable
class UserDTO(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val username: String,
    val fullName: String,
    val role: Role
)