package di

import AuthService
import UserService
import SupplierService
import ToolService
import impl.AuthServiceImpl
import impl.UserServiceImpl
import impl.SupplierServiceImpl
import impl.ToolServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val servicesModule = module {
    singleOf(::AuthServiceImpl) { bind<AuthService>() }
    singleOf(::UserServiceImpl) { bind<UserService>() }
    singleOf(::SupplierServiceImpl) { bind<SupplierService>() }
    singleOf(::ToolServiceImpl) { bind<ToolService>() }
}