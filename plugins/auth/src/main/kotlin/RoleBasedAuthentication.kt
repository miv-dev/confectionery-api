import exceptions.AppException
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import user.Role

class PluginConfiguration {
    var roles: Set<Role> = emptySet()
}

val RoleBasedAuthorizationPlugin = createRouteScopedPlugin(
    "RbacPlugin",
    createConfiguration = ::PluginConfiguration
) {
    val roles = pluginConfig.roles
    pluginConfig.apply {
        on(AuthenticationChecked) { call ->
            val role = getRoleFromCall(call)
            val authorized = roles.contains(role)

            if (!authorized) {
                throw AppException.Unauthorized("User does not have any of the following roles: $roles")
            }
        }
    }
}

private fun getRoleFromCall(call: ApplicationCall): Role? {
    val session = call.principal<Session>()

    return session?.role
}

fun Route.withAnyRole(vararg roles: Role, build: Route.() -> Unit) = authorized(*roles, build = build)

private fun Route.authorized(
    vararg hasAnyRole: Role,
    build: Route.() -> Unit
): Route {
    val authorizedRoute = createChild(AuthenticationRouteSelector(hasAnyRole.toList().map { it.toString() }))
    authorizedRoute.install(RoleBasedAuthorizationPlugin) {
        roles = hasAnyRole.toSet()
    }
    authorizedRoute.build()
    return authorizedRoute
}