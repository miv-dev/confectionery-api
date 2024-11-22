package di

import AuthService
import UserService
import impl.AuthServiceImpl
import impl.UserServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val servicesModule = module {
    singleOf(::AuthServiceImpl) { bind<AuthService>() }
    singleOf(::UserServiceImpl) { bind<UserService>() }
}