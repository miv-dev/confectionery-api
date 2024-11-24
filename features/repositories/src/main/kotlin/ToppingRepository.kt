import topping.Topping
import topping.ToppingType
import java.time.LocalDate

interface ToppingRepository {
    suspend fun search(type: ToppingType?, shelfLife: LocalDate?): List<Topping>

    suspend fun getTypeByID(id: Int): ToppingType?

    suspend fun getToppingByID(id: Int): Topping?

    suspend fun getTypes(): List<ToppingType>

    suspend fun create(topping: Topping): Topping

    suspend fun update(topping: Topping): Topping

    suspend fun delete(id: Int)
}
