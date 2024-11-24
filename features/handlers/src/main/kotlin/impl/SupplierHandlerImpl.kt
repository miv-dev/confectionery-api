package impl

import SupplierHandler
import SupplierService
import io.ktor.server.application.*
import io.ktor.server.response.*
import mapper.toDTO

class SupplierHandlerImpl(
    private val service: SupplierService
) : SupplierHandler {
    override suspend fun list(call: ApplicationCall) {
        call.respond(service.list().map { it.toDTO() })
    }
}