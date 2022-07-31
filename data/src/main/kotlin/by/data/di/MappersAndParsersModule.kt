package by.data.di

import by.data.database.entity.CoffeeEntity
import by.data.database.entity.InfusionEntity
import by.data.database.entity.ProfileEntity
import by.data.database.relations.ProfileWithCoffeeAndInfusions
import by.data.parsres.Mapper
import by.data.parsres.Parser
import by.data.parsres.localData.MapperProfileDomainToEntity
import by.data.parsres.localData.MapperProfileEntityToDomain
import by.data.parsres.localData.ParserCoffeeDomainEntity
import by.data.parsres.localData.ParserInfusionDomainEntity
import by.data.parsres.remoteData.ParserCoffeeDomainRemote
import by.data.parsres.remoteData.ParserGroupDomainRemote
import by.data.parsres.remoteData.ParserInfusionDomainRemote
import by.data.parsres.remoteData.ParserProfileDomainRemote
import by.data.parsres.remoteData.ParserUserDomainRemote
import by.data.remote.entities.CoffeeRemote
import by.data.remote.entities.GroupRemote
import by.data.remote.entities.InfusionRemote
import by.data.remote.entities.ProfileRemote
import by.data.remote.entities.UserRemote
import by.domain.entities.Coffee
import by.domain.entities.Group
import by.domain.entities.Infusion
import by.domain.entities.Profile
import by.domain.entities.User
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

    @Binds
    @Singleton
    internal abstract fun bindParserCoffeeDomainRemote(parserCoffeeDomainRemote: ParserCoffeeDomainRemote):
            Parser<Coffee, CoffeeRemote>

    @Binds
    @Singleton
    internal abstract fun bindParserInfusionDomainRemote(parserInfusionDomainRemote: ParserInfusionDomainRemote):
            Parser<Infusion, InfusionRemote>

    @Binds
    @Singleton
    internal abstract fun bindParserGroupDomainRemote(parserGroupDomainRemote: ParserGroupDomainRemote):
            Parser<Group, GroupRemote>

    @Binds
    @Singleton
    internal abstract fun bindParserUserDomainRemote(parserUserDomainRemote: ParserUserDomainRemote):
            Parser<User, UserRemote>

    @Binds
    @Singleton
    internal abstract fun bindParserProfileDomainRemote(parserProfileDomainRemote: ParserProfileDomainRemote):
            Parser<Profile, ProfileRemote>

}
