package impl

import ToolHandler
import ToolService
import dto.CreateToolRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import mapper.toDTO

class ToolHandlerImpl(
    private val service: ToolService
) : ToolHandler {
    override suspend fun list(call: ApplicationCall) {
        val tools = service.list().map { it.toDTO()}
        call.respond(tools)
    }

    override suspend fun allTypes(call: ApplicationCall) {
        val types = service.allTypes().map { it.toDTO() }
        call.respond(types)
    }

    override suspend fun create(call: ApplicationCall) {
        val data = call.receive<CreateToolRequest>()

        val tool = service.create(
            data.name,
            data.description,
            data.supplierId,
            data.wear,
            data.typeId,
            data.purchaseDate,
            data.quantity
        ).toDTO()

        call.respond(tool)
    }
}