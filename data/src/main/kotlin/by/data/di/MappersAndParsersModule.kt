package by.data.di

import by.data.localData.database.entity.CoffeeEntity
import by.data.localData.database.entity.InfusionEntity
import by.data.localData.database.entity.ProfileEntity
import by.data.localData.database.relations.ProfileWithCoffeeAndInfusions
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
import by.data.remoteData.remoteDataBase.entities.CoffeeRemote
import by.data.remoteData.remoteDataBase.entities.GroupRemote
import by.data.remoteData.remoteDataBase.entities.InfusionRemote
import by.data.remoteData.remoteDataBase.entities.ProfileRemote
import by.data.remoteData.remoteDataBase.entities.UserRemote
import by.domain.entities.Coffee
import by.domain.entities.Group
import by.domain.entities.Infusion
import by.domain.entities.Profile
import by.domain.entities.User
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MappersAndParsersModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindMapperProfileEntityToDomain(mapperProfileEntityToDomain: MapperProfileEntityToDomain):
            Mapper<ProfileWithCoffeeAndInfusions, Profile>

    @Binds
    @ViewModelScoped
    internal abstract fun bindMapperProfileDomainToEntity(mapperProfileDomainToEntity: MapperProfileDomainToEntity):
            Mapper<Profile, ProfileEntity>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserCoffeeDomainEntity(parserCoffeeDomainEntity: ParserCoffeeDomainEntity):
            Parser<Coffee, CoffeeEntity>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserInfusionDomainEntity(parserInfusionDomainEntity: ParserInfusionDomainEntity):
            Parser<Infusion, InfusionEntity>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserCoffeeDomainRemote(parserCoffeeDomainRemote: ParserCoffeeDomainRemote):
            Parser<Coffee, CoffeeRemote>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserInfusionDomainRemote(parserInfusionDomainRemote: ParserInfusionDomainRemote):
            Parser<Infusion, InfusionRemote>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserGroupDomainRemote(parserGroupDomainRemote: ParserGroupDomainRemote):
            Parser<Group, GroupRemote>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserUserDomainRemote(parserUserDomainRemote: ParserUserDomainRemote):
            Parser<User, UserRemote>

    @Binds
    @ViewModelScoped
    internal abstract fun bindParserProfileDomainRemote(parserProfileDomainRemote: ParserProfileDomainRemote):
            Parser<Profile, ProfileRemote>

}
