package by.ocheretny.data.di

import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.database.entity.InfusionEntity
import by.ocheretny.data.database.entity.ProfileEntity
import by.ocheretny.data.database.relations.ProfileWithCoffeeAndInfusions
import by.ocheretny.data.mappers.Mapper
import by.ocheretny.data.mappers.fromDomainToEntity.MapperCoffeeDomainToEntity
import by.ocheretny.data.mappers.fromDomainToEntity.MapperInfusionDomainToEntity
import by.ocheretny.data.mappers.fromDomainToEntity.MapperProfileDomainToEntity
import by.ocheretny.data.mappers.fromEntityToDomain.MapperCoffeeEntityToDomain
import by.ocheretny.data.mappers.fromEntityToDomain.MapperInfusionEntityToDomain
import by.ocheretny.data.mappers.fromEntityToDomain.MapperProfileEntityToDomain
import by.ocheretny.domain.entity.Coffee
import by.ocheretny.domain.entity.Infusion
import by.ocheretny.domain.entity.Profile
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
    internal abstract fun bindMapperCoffeeEntityToDomain(mapperCoffeeDomainToEntity: MapperCoffeeDomainToEntity):
            Mapper<Coffee, CoffeeEntity>

    @Binds
    internal abstract fun bindMapperInfusionDomainToEntity(MapperInfusionDomainToEntity: MapperInfusionDomainToEntity):
            Mapper<Infusion, InfusionEntity>

    @Binds
    internal abstract fun bindMapperProfileDomainToEntity(mapperProfileDomainToEntity: MapperProfileDomainToEntity):
            Mapper<Profile, ProfileEntity>

}