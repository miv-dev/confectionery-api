package di

import AuthHandler
import impl.AuthHandlerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val handlersModule = module {
    singleOf(::AuthHandlerImpl){ bind<AuthHandler>() }
}