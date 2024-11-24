package mapper

import dto.SupplierDTO
import supplier.Supplier


fun SupplierDTO.toModel() = Supplier(
    id = id,
    name = name,
    address = address,
    deliveryTime = deliveryTime
)

fun Supplier.toDTO() = SupplierDTO(
    id = id,
    name = name,
    address = address,
    deliveryTime = deliveryTime
)