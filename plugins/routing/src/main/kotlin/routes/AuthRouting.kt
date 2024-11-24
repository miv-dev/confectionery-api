package routes

import AuthHandler
import dto.LoginRequest
import dto.RegisterRequest
import dto.UserDTO
import io.github.smiley4.ktorswaggerui.dsl.routing.post
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.authRouting() {
    val handler by inject<AuthHandler>()

    route("/auth") {
        post("/login", {
            description = "Login to the system"
            request {
                body<LoginRequest> {
                    description = "Credentials"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Successful login"
                    body<UserDTO> {
                        description = "User data"
                    }
                }
            }
        }, {
            handler.login(call)
        })
        post("/register", {
            description = "Register a new user"
            request {
                body<RegisterRequest> {
                    description = "User data"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Successful registration"
                    body<UserDTO> {
                        description = "User data"
                    }
                }
            }
        }) {
            handler.register(call)
        }
    }
}