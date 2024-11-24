import tool.Tool
import tool.ToolType

interface ToolRepository {

    suspend fun list(): List<Tool>

    suspend fun allTypes(): List<ToolType>

    suspend fun getTypeById(id: Int): ToolType?

    suspend fun create(tool: Tool): Tool
}