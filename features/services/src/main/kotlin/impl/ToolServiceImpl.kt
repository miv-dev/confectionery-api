package impl

import SupplierRepository
import ToolRepository
import ToolService
import exceptions.AppException
import tool.Tool
import tool.ToolType
import tool.Wear
import java.time.LocalDate

class ToolServiceImpl(
    private val toolRepo: ToolRepository,
    private val supplierRepo: SupplierRepository
) : ToolService {
    override suspend fun list(): List<Tool> {
        return toolRepo.list()
    }

    override suspend fun allTypes(): List<ToolType> {
        return toolRepo.allTypes()
    }

    override suspend fun create(
        name: String,
        description: String,
        supplierId: Int,
        wear: Wear,
        typeId: Int,
        purchaseDate: LocalDate,
        quantity: Int
    ): Tool {
        val supplier = supplierRepo.getById(supplierId) ?: throw AppException.NotFound("Supplier not found")
        val type = toolRepo.getTypeById(typeId) ?: throw AppException.NotFound("Tool type not found")

        val tool = Tool(
            id = INVALID_ID,
            name = name,
            description = description,
            supplier = supplier,
            wear = wear,
            type = type,
            purchaseDate = purchaseDate,
            quantity = quantity
        )
        return toolRepo.create(tool)
    }


    companion object{

        const val INVALID_ID = -1
    }
}