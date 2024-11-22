package routes

import AuthHandler
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.authRouting() {
    val handler by inject<AuthHandler>()

    route("/auth") {
        post("/login") {
            handler.login(call)
        }
        post("/register") {
            handler.register(call)
        }
    }
}