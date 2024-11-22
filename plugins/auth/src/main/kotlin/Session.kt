import io.ktor.server.auth.*
import kotlinx.serialization.Serializable
import user.Role

@Serializable
data class Session(val username: String, val role: Role): Principal
