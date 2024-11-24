package tool

import supplier.Supplier
import java.time.LocalDate

data class Tool(
    val id: Int,
    val name: String,
    val description: String,
    val supplier: Supplier,
    val wear: Wear,
    val type: ToolType,
    val purchaseDate: LocalDate,
    val quantity: Int
)

