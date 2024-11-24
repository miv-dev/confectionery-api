package impl

import SupplierRepository
import SupplierService
import supplier.Supplier

class SupplierServiceImpl(
    private val supplierRepo: SupplierRepository
) : SupplierService {
    override suspend fun list(): List<Supplier> {
        return supplierRepo.list()
    }
}