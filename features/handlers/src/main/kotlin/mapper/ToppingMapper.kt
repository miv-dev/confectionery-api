package mapper

import dto.ToppingDTO
import dto.ToppingTypeDTO
import topping.Topping
import topping.ToppingType

fun Topping.toDTO() = ToppingDTO(
    id = id,
    name = name,
    article = article,
    type = type.toDTO(),
    quantity = quantity,
    unit = unit,
    purchasePrice = purchasePrice,
    supplier = supplier?.toDTO(),
    deliveryDuration = deliveryDuration,
    shelfLife = shelfLife
)

fun ToppingType.toDTO() = ToppingTypeDTO(
    id = id,
    name = name
)