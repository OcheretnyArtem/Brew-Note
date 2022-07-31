package by.ocheretny.brewnote.di

import by.data.parsres.Mapper
import by.domain.entities.Coffee
import by.domain.entities.Infusion
import by.domain.entities.Profile
import by.ocheretny.brewnote.entities.CoffeeUI
import by.ocheretny.brewnote.entities.InfusionUI
import by.ocheretny.brewnote.entities.ProfileUI
import by.ocheretny.brewnote.mappers.MapperCoffeeDomainToUI
import by.ocheretny.brewnote.mappers.MapperInfusionDomainToUI
import by.ocheretny.brewnote.mappers.MapperProfileDomainToUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MappersModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindMapperCoffeeDomainToUI(mapperCoffeeDomainToUI: MapperCoffeeDomainToUI):
            Mapper<Coffee, CoffeeUI>

    @Binds
    @ViewModelScoped
    internal abstract fun bindMapperInfusionDomainToUI(mapperInfusionDomainToUI: MapperInfusionDomainToUI):
            Mapper<Infusion, InfusionUI>

    @Binds
    @ViewModelScoped
    internal abstract fun bindMapperProfileDomainToUI(mapperProfileDomainToUI: MapperProfileDomainToUI):
            Mapper<Profile, ProfileUI>
}
