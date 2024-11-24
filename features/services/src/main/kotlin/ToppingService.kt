import topping.Topping
import topping.ToppingType
import java.time.LocalDate

interface ToppingService {
    suspend fun search(typeID: Int?, shelfLife: LocalDate?): List<Topping>

    suspend fun getTypes(): List<ToppingType>

    suspend fun create(
        article: String,
        typeID: Int,
        name: String,
        quantity: Int?,
        unit: String?,
        purchasePrice: Double?,
        supplierID: Int?,
        deliveryDuration: Int?,
        shelfLife: LocalDate?
    ): Topping

    suspend fun update(
        id: Int,
        article: String,
        typeID: Int,
        name: String,
        quantity: Int?,
        unit: String?,
        purchasePrice: Double?,
        supplierID: Int?,
        deliveryDuration: Int?,
        shelfLife: LocalDate?
    ): Topping

    suspend fun delete(id: Int)
}