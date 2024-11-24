package di

import UserRepository
import SupplierRepository
import ToolRepository
import ToppingRepository
import impl.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val repositoriesModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::SupplierRepositoryImpl) { bind<SupplierRepository>() }
    singleOf(::ToolRepositoryImpl) { bind<ToolRepository>() }
    singleOf(::ToppingRepositoryImpl) { bind<ToppingRepository>() }
}