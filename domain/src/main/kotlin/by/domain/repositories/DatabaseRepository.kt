package by.domain.repositories

import by.domain.entities.Coffee
import by.domain.entities.Infusion
import by.domain.entities.Profile
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    suspend fun getProfileById(id: Int): Profile

    suspend fun getAllProfiles() : Flow<List<Profile>>

    suspend fun getAllCoffee() : Flow<List<Coffee>>

    suspend fun insert(profile: Profile)

    suspend fun insert(coffee: Coffee)

    suspend fun insert(infusion: Infusion)

    suspend fun insert(infusions: List<Infusion>)

    suspend fun delete(coffee: Coffee)

    suspend fun delete(profile: Profile)

}
