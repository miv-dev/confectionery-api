import supplier.Supplier

interface SupplierRepository {

    suspend fun list(): List<Supplier>

    suspend fun getById(id: Int): Supplier?


    suspend fun getByName(name: String): Supplier?
}