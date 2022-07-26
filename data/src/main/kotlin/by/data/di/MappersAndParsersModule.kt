package by.data.di

import by.data.database.entity.CoffeeEntity
import by.data.database.entity.InfusionEntity
import by.data.database.entity.ProfileEntity
import by.data.database.relations.ProfileWithCoffeeAndInfusions
import by.data.parsres.Mapper
import by.data.parsres.Parser
import by.data.parsres.domain.MapperProfileDomainToEntity
import by.data.parsres.domain.MapperProfileEntityToDomain
import by.data.parsres.domain.ParserCoffeeDomainEntity
import by.data.parsres.domain.ParserInfusionDomainEntity
import by.domain.entity.Coffee
import by.domain.entity.Infusion
import by.domain.entity.Profile
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersAndParsersModule {

    @Binds
    @Singleton
    internal abstract fun bindMapperProfileEntityToDomain(mapperProfileEntityToDomain: MapperProfileEntityToDomain):
            Mapper<ProfileWithCoffeeAndInfusions, Profile>

    @Binds
    @Singleton
    internal abstract fun bindMapperProfileDomainToEntity(mapperProfileDomainToEntity: MapperProfileDomainToEntity):
            Mapper<Profile, ProfileEntity>

    @Binds
    @Singleton
    internal abstract fun bindParserCoffeeDomainEntity(parserCoffeeDomainEntity: ParserCoffeeDomainEntity):
            Parser<Coffee, CoffeeEntity>

    @Binds
    @Singleton
    internal abstract fun bindParserInfusionDomainEntity(parserInfusionDomainEntity: ParserInfusionDomainEntity):
            Parser<Infusion, InfusionEntity>

}
