package impl

import ToolRepository
import entities.SupplierEntity
import entities.ToolEntity
import entities.ToolTypeEntity
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import tool.Tool
import tool.ToolType

class ToolRepositoryImpl : ToolRepository {
    override suspend fun list(): List<Tool> = newSuspendedTransaction {
        ToolEntity.all().map(ToolEntity::toModel)
    }

    override suspend fun allTypes(): List<ToolType> = newSuspendedTransaction {
        ToolTypeEntity.all().map(ToolTypeEntity::toModel)
    }

    override suspend fun getTypeById(id: Int): ToolType? = newSuspendedTransaction {
        ToolTypeEntity.findById(id)?.toModel()
    }

    override suspend fun create(tool: Tool): Tool = newSuspendedTransaction {
        ToolEntity.new {
            name = tool.name
            description = tool.description
            supplier = SupplierEntity[tool.supplier.id]
            wear = tool.wear
            type = ToolTypeEntity[tool.type.id]
            purchaseDate = tool.purchaseDate
            quantity = tool.quantity
        }.toModel()
    }
}