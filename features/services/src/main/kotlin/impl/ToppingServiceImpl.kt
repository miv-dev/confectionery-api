package impl

import SupplierRepository
import ToppingRepository
import ToppingService
import exceptions.AppException
import topping.Topping
import topping.ToppingType
import java.time.LocalDate

class ToppingServiceImpl(
    private val toppingRepo: ToppingRepository,
    private val supplierRepo: SupplierRepository,
) : ToppingService {
    override suspend fun search(typeID: Int?, shelfLife: LocalDate?): List<Topping> {
        val type = if(typeID != null) toppingRepo.getTypeByID(typeID) ?: throw AppException.NotFound("Topping type with ID $typeID not found") else null

        return toppingRepo.search(type, shelfLife)
    }

    override suspend fun getTypes(): List<ToppingType> {
        return toppingRepo.getTypes()
    }

    override suspend fun create(
        article: String,
        typeID: Int,
        name: String,
        quantity: Int?,
        unit: String?,
        purchasePrice: Double?,
        supplierID: Int?,
        deliveryDuration: Int?,
        shelfLife: LocalDate?
    ): Topping {
        val type =
            toppingRepo.getTypeByID(typeID) ?: throw AppException.NotFound("Topping type with ID $typeID not found")
        val supplier = if (supplierID != null) {
            supplierRepo.getById(supplierID) ?: throw AppException.NotFound("Supplier with ID $supplierID not found")
        } else {
            null
        }
        val topping = Topping(
            id = INVALID_ID,
            article = article,
            type = type,
            name = name,
            quantity = quantity,
            unit = unit,
            purchasePrice = purchasePrice,
            supplier = supplier,
            deliveryDuration = deliveryDuration,
            shelfLife = shelfLife
        )

        return toppingRepo.create(
            topping
        )
    }

    override suspend fun update(
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
    ): Topping {
        val type =
            toppingRepo.getTypeByID(typeID) ?: throw AppException.NotFound("Topping type with ID $typeID not found")
        val supplier = if (supplierID != null) {
            supplierRepo.getById(supplierID) ?: throw AppException.NotFound("Supplier with ID $supplierID not found")
        } else {
            null
        }
        val topping = Topping(
            id = id,
            article = article,
            type = type,
            name = name,
            quantity = quantity,
            unit = unit,
            purchasePrice = purchasePrice,
            supplier = supplier,
            deliveryDuration = deliveryDuration,
            shelfLife = shelfLife
        )

        return toppingRepo.update(
            topping
        )
    }

    override suspend fun delete(id: Int) {
        toppingRepo.getToppingByID(id) ?: throw AppException.NotFound("Topping with ID $id not found")

        toppingRepo.delete(id)
    }

    companion object {
        private const val INVALID_ID = -1
    }
}