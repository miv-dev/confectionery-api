import tool.Tool
import tool.ToolType
import tool.Wear
import java.time.LocalDate

interface ToolService {

    suspend fun list(): List<Tool>

    suspend fun allTypes(): List<ToolType>

    suspend fun create(
        name: String,
        description: String,
        supplierId: Int,
        wear: Wear,
        typeId: Int,
        purchaseDate: LocalDate,
        quantity: Int
    ): Tool
}