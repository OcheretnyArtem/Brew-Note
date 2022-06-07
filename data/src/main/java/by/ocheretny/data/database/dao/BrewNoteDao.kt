package by.ocheretny.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Transaction
import androidx.room.Query
import androidx.room.Update
import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.database.entity.InfusionEntity
import by.ocheretny.data.database.entity.ProfileEntity
import by.ocheretny.data.database.relations.CoffeeWithProfiles
import by.ocheretny.data.database.relations.ProfileWithCoffeeAndInfusions
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

@InternalCoroutinesApi
@Dao
internal interface BrewNoteDao {

    @Insert
    suspend fun insert(coffee: CoffeeEntity)

    @Insert
    suspend fun insert(profile: ProfileEntity)

    @Insert
    suspend fun insert(infusion: InfusionEntity)

    @Insert
    suspend fun insert(infusions: List<InfusionEntity>)

    @Delete
    suspend fun delete(coffee: CoffeeEntity)

    @Delete
    suspend fun delete(profile: ProfileEntity)

    @Delete
    suspend fun delete(infusion: InfusionEntity)

    @Transaction
    suspend fun delete(profile: ProfileWithCoffeeAndInfusions) {
        profile.infusions.forEach {
            delete(it)
        }
        delete(profile.profile)
    }

    @Transaction
    suspend fun delete(coffee: CoffeeWithProfiles) {
        coffee.profiles.forEach { profile ->
            delete(getProfileById(profile.id))
        }
        delete(coffee.coffee)
    }

    @Update
    suspend fun update(coffee: CoffeeEntity)

    @Update
    suspend fun update(profile: ProfileEntity)

    @Query("SELECT * FROM profile_table")
    fun getAllProfiles(): Flow<List<ProfileWithCoffeeAndInfusions>>

    @Query("SELECT * FROM profile_table WHERE id LIKE :id")
    suspend fun getProfileById(id: Int): ProfileWithCoffeeAndInfusions

    @Query("SELECT * FROM coffee_table WHERE id LIKE :coffeeId")
    suspend fun getCoffeeWithProfilesByCoffeeId(coffeeId: Int): CoffeeWithProfiles

    @Query("SELECT * FROM coffee_table")
    fun getAllCoffee() : Flow<List<CoffeeEntity>>
}