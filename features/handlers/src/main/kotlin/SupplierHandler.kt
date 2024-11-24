import io.ktor.server.application.*

interface SupplierHandler {

    suspend fun list(call: ApplicationCall)

}