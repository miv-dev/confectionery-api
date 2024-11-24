package routes

import ToolHandler
import dto.CreateToolRequest
import dto.ToolDTO
import dto.ToolTypeDTO
import io.github.smiley4.ktorswaggerui.data.array
import io.github.smiley4.ktorswaggerui.dsl.routing.get
import io.github.smiley4.ktorswaggerui.dsl.routing.post
import io.ktor.client.utils.EmptyContent.status
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import tool.ToolType
import user.Role
import withAnyRole

fun Route.toolRouting() {

    val handler by inject<ToolHandler>()

    route("/tools") {
        get({
            description = "List all tools"
            response {
                HttpStatusCode.OK to {
                    description = "List of tools"
                    body(array<ToolDTO>())
                }
            }
        }) {
            handler.list(call)
        }
        get("/types", {
            description = "List all tool types"
            response {
                HttpStatusCode.OK to {
                    description = "List of tool types"
                    body(array<ToolTypeDTO>())
                }
            }
        }) {
            handler.allTypes(call)
        }
//        withAnyRole(Role.DIRECTOR) {
        post({
            description = "Create a new tool"
            request {
                body<CreateToolRequest> {
                    description = "Tool data"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Created tool"
                    body<ToolDTO> {
                        description = "Tool data"
                    }
                }
            }
        }) {
            handler.create(call)
        }
//        }
    }
}