import supplier.Supplier

interface SupplierService {
    suspend fun list(): List<Supplier>
}