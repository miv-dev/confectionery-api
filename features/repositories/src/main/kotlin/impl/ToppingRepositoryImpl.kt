package impl

import ToppingRepository
import entities.SupplierEntity
import entities.ToppingEntity
import entities.ToppingTypeEntity
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import tables.Toppings
import topping.Topping
import topping.ToppingType
import java.time.LocalDate

class ToppingRepositoryImpl : ToppingRepository {
    override suspend fun search(type: ToppingType?, shelfLife: LocalDate?): List<Topping> = newSuspendedTransaction {
        val query = Toppings.selectAll()
        type?.let {
            query.andWhere { Toppings.type eq type.id }
        }
        shelfLife?.let {
            query.andWhere { Toppings.shelfLife lessEq shelfLife }
        }

        ToppingEntity.wrapRows(query).map { it.toModel() }
    }

    override suspend fun getTypeByID(id: Int): ToppingType? = newSuspendedTransaction {
        ToppingTypeEntity.findById(id)?.toModel()
    }

    override suspend fun getToppingByID(id: Int): Topping? = newSuspendedTransaction {
        ToppingEntity.findById(id)?.toModel()
    }

    override suspend fun getTypes(): List<ToppingType> = newSuspendedTransaction {
        ToppingTypeEntity.all().map { it.toModel() }
    }

    override suspend fun create(topping: Topping): Topping = newSuspendedTransaction {
        ToppingEntity.new {
            article = topping.article
            name = topping.name
            type = ToppingTypeEntity[topping.type.id]
            quantity = topping.quantity
            unit = topping.unit
            purchasePrice = topping.purchasePrice
            supplier = topping.supplier?.let { SupplierEntity[it.id] }
            deliveryDuration = topping.deliveryDuration
            shelfLife = topping.shelfLife
        }.toModel()
    }

    override suspend fun update(topping: Topping): Topping = newSuspendedTransaction {
        ToppingEntity.findByIdAndUpdate(topping.id) { entity ->
            entity.article = topping.article
            entity.name = topping.name
            entity.type = ToppingTypeEntity[topping.type.id]
            entity.quantity = topping.quantity
            entity.unit = topping.unit
            entity.purchasePrice = topping.purchasePrice
            entity.supplier = topping.supplier?.let { SupplierEntity[it.id] }
            entity.deliveryDuration = topping.deliveryDuration
            entity.shelfLife = topping.shelfLife
        }?.toModel() ?: throw IllegalArgumentException("Check in service layer if topping exists")
    }

    override suspend fun delete(id: Int) {
        transaction {
            ToppingEntity[id].delete()
        }
    }
}