package by.data.parsres.localData

import by.data.localData.database.entity.CoffeeEntity
import by.data.localData.database.entity.InfusionEntity
import by.data.localData.database.relations.ProfileWithCoffeeAndInfusions
import by.data.parsres.Mapper
import by.data.parsres.Parser
import by.domain.entities.Coffee
import by.domain.entities.Infusion
import by.domain.entities.Profile
import javax.inject.Inject

internal class MapperProfileEntityToDomain @Inject constructor(
    private val mapperCoffeeEntityToDomain: Parser<Coffee, CoffeeEntity>,
    private val mapperInfusionEntityToDomain: Parser<Infusion, InfusionEntity>,
) : Mapper<ProfileWithCoffeeAndInfusions, Profile> {

    override fun map(from: ProfileWithCoffeeAndInfusions): Profile = Profile(
        localId = from.profile.id,
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
