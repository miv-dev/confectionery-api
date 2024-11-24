package di

import AuthHandler
import SupplierHandler
import ToolHandler
import ToppingHandler
import impl.AuthHandlerImpl
import impl.SupplierHandlerImpl
import impl.ToolHandlerImpl
import impl.ToppingHandlerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val handlersModule = module {
    singleOf(::AuthHandlerImpl){ bind<AuthHandler>() }
    singleOf(::SupplierHandlerImpl) { bind<SupplierHandler>() }
    singleOf(::ToolHandlerImpl) { bind<ToolHandler>() }
    singleOf(::ToppingHandlerImpl) { bind<ToppingHandler>() }
}