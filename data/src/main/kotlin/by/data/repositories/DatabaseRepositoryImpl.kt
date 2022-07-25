package by.data.repositories

import by.data.database.dao.BrewNoteDao
import by.data.database.entity.CoffeeEntity
import by.data.database.entity.InfusionEntity
import by.data.database.entity.ProfileEntity
import by.data.database.relations.ProfileWithCoffeeAndInfusions
import by.data.mappers.Mapper
import by.domain.entity.Coffee
import by.domain.entity.Infusion
import by.domain.entity.Profile
import by.domain.repositories.DatabaseRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@InternalCoroutinesApi
internal class DatabaseRepositoryImpl @Inject constructor(
    private val dao: BrewNoteDao,
    private val entityProfileToDomainMapper: Mapper<ProfileWithCoffeeAndInfusions, Profile>,
    private val entityCoffeeToDomainMapper: Mapper<CoffeeEntity, Coffee>,
    private val mapperCoffeeDomainToEntity: Mapper<Coffee, CoffeeEntity>,
    private val mapperInfusionDomainToEntity: Mapper<Infusion, InfusionEntity>,
    private val mapperProfileDomainToEntity: Mapper<Profile, ProfileEntity>,
    private val dispatchers: CoroutineDispatcher,
) : DatabaseRepository {

    override suspend fun getProfileById(id: Int): Profile = withContext(dispatchers) {
        entityProfileToDomainMapper.map(dao.getProfileById(id))
    }

    override suspend fun getAllProfiles(): Flow<List<Profile>> = dao.getAllProfiles().map {
        return@map it.map { profile ->
            entityProfileToDomainMapper.map(profile)
        }
    }.flowOn(dispatchers)

    override suspend fun getAllCoffee(): Flow<List<Coffee>> = dao.getAllCoffee().map {
        return@map it.map { coffee ->
            entityCoffeeToDomainMapper.map(coffee)
        }
    }.flowOn(dispatchers)

    override suspend fun insert(profile: Profile) = withContext(dispatchers) {
        dao.insert(mapperProfileDomainToEntity.map(profile))
    }

    override suspend fun insert(coffee: Coffee) = withContext(dispatchers) {
        dao.insert(mapperCoffeeDomainToEntity.map(coffee))
    }

    override suspend fun insert(infusion: Infusion) = withContext(dispatchers) {
        dao.insert(mapperInfusionDomainToEntity.map(infusion))
    }

    override suspend fun insert(infusions: List<Infusion>) = withContext(dispatchers) {
        infusions.forEach { infusion ->
            dao.insert(mapperInfusionDomainToEntity.map(infusion))
        }
    }

    override suspend fun delete(coffee: Coffee) = withContext(dispatchers) {
        dao.delete(dao.getCoffeeWithProfilesByCoffeeId(coffee.id!!))
    }

    override suspend fun delete(profile: Profile) = withContext(dispatchers) {
        dao.delete(dao.getProfileById(profile.coffee.id!!))
    }
}
