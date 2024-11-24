package impl

import SupplierRepository
import entities.SupplierEntity
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import supplier.Supplier
import tables.Suppliers

class SupplierRepositoryImpl : SupplierRepository {
    override suspend fun list(): List<Supplier> = newSuspendedTransaction {
        SupplierEntity.all().map(SupplierEntity::toModel)
    }

    override suspend fun getById(id: Int): Supplier? = newSuspendedTransaction {
        SupplierEntity.findById(id)?.toModel()
    }


    override suspend fun getByName(name: String): Supplier? = newSuspendedTransaction {
        SupplierEntity.find { Suppliers.name eq name }.firstOrNull()?.toModel()
    }
}