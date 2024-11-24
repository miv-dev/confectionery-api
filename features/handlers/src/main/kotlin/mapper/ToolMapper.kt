package mapper

import dto.ToolDTO
import dto.ToolTypeDTO
import tool.Tool
import tool.ToolType

fun ToolDTO.toModel() = Tool(
    id = id,
    name = name,
    description = description,
    supplier = supplier.toModel(),
    wear = wear,
    type = type.toModel(),
    purchaseDate = purchaseDate,
    quantity = quantity
)

fun Tool.toDTO() = ToolDTO(
    id = id,
    name = name,
    description = description,
    supplier = supplier.toDTO(),
    wear = wear,
    type = type.toDTO(),
    purchaseDate = purchaseDate,
    quantity = quantity
)


fun ToolTypeDTO.toModel() = ToolType(
    id = id,
    name = name
)

fun ToolType.toDTO() = ToolTypeDTO(
    id = id,
    name = name
)