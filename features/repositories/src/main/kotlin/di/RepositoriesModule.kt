package di

import UserRepository
import impl.UserRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoriesModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
}