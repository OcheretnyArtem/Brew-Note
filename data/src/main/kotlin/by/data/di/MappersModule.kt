package by.data.di

import by.data.database.entity.CoffeeEntity
import by.data.database.entity.InfusionEntity
import by.data.database.entity.ProfileEntity
import by.data.database.relations.ProfileWithCoffeeAndInfusions
import by.data.mappers.Mapper
import by.data.mappers.fromDomainToEntity.MapperCoffeeDomainToEntity
import by.data.mappers.fromDomainToEntity.MapperInfusionDomainToEntity
import by.data.mappers.fromDomainToEntity.MapperProfileDomainToEntity
import by.data.mappers.fromEntityToDomain.MapperCoffeeEntityToDomain
import by.data.mappers.fromEntityToDomain.MapperInfusionEntityToDomain
import by.data.mappers.fromEntityToDomain.MapperProfileEntityToDomain
import by.domain.entity.Coffee
import by.domain.entity.Infusion
import by.domain.entity.Profile
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    internal abstract fun bindMapperCoffeeEntityToDomain(mapperCoffeeEntityToDomain: MapperCoffeeEntityToDomain):
            Mapper<CoffeeEntity, Coffee>

    @Binds
    internal abstract fun bindMapperProfileEntityToDomain(mapperProfileEntityToDomain: MapperProfileEntityToDomain):
            Mapper<ProfileWithCoffeeAndInfusions, Profile>

    @Binds
    internal abstract fun bindMapperInfusionEntityToDomain(mapperInfusionEntityToDomain: MapperInfusionEntityToDomain):
            Mapper<InfusionEntity, Infusion>

    @Binds
    internal abstract fun bindMapperCoffeeDomainToEntity(mapperCoffeeDomainToEntity: MapperCoffeeDomainToEntity):
            Mapper<Coffee, CoffeeEntity>

    @Binds
    internal abstract fun bindMapperInfusionDomainToEntity(MapperInfusionDomainToEntity: MapperInfusionDomainToEntity):
            Mapper<Infusion, InfusionEntity>

    @Binds
    internal abstract fun bindMapperProfileDomainToEntity(mapperProfileDomainToEntity: MapperProfileDomainToEntity):
            Mapper<Profile, ProfileEntity>

}
