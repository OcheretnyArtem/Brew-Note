package by.data.parsres.domain

import by.data.database.entity.CoffeeEntity
import by.data.database.entity.InfusionEntity
import by.data.database.relations.ProfileWithCoffeeAndInfusions
import by.data.parsres.Mapper
import by.data.parsres.Parser
import by.domain.entity.Coffee
import by.domain.entity.Infusion
import by.domain.entity.Profile
import javax.inject.Inject

internal class MapperProfileEntityToDomain @Inject constructor(
    private val mapperCoffeeEntityToDomain: Parser<Coffee, CoffeeEntity>,
    private val mapperInfusionEntityToDomain: Parser<Infusion, InfusionEntity>,
) : Mapper<ProfileWithCoffeeAndInfusions, Profile> {

    override fun map(from: ProfileWithCoffeeAndInfusions): Profile = Profile(
        id = from.profile.id,
        coffee = mapperCoffeeEntityToDomain.pars(from.coffee),
        infusions = from.infusions.map { mapperInfusionEntityToDomain.pars(it) },
        device = from.profile.device,
        totalTime = from.profile.totalTime,
        totalWaterWeight = from.profile.totalWaterWeight,
        waterTemperature = from.profile.waterTemperature,
        dryCoffeeWeight = from.profile.dryCoffeeWeight,
        grinderName = from.profile.grinderName,
        grinderSetting = from.profile.grinderSetting,
        description = from.profile.description,
        brewedCoffeeWeight = from.profile.brewedCoffeeWeight,
        tds = from.profile.tds,
        extraction = from.profile.extraction
    )
}
