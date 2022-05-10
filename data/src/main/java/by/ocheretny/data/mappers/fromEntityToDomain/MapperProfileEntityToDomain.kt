package by.ocheretny.data.mappers.fromEntityToDomain

import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.database.entity.InfusionEntity
import by.ocheretny.data.database.relations.ProfileWithCoffeeAndInfusions
import by.ocheretny.data.mappers.Mapper
import by.ocheretny.domain.entity.Coffee
import by.ocheretny.domain.entity.Infusion
import by.ocheretny.domain.entity.Profile
import javax.inject.Inject

internal class MapperProfileEntityToDomain @Inject constructor(
    private val mapperCoffeeEntityToDomain: Mapper<CoffeeEntity, Coffee>,
    private val mapperInfusionEntityToDomain: Mapper<InfusionEntity, Infusion>,
) : Mapper<ProfileWithCoffeeAndInfusions, Profile> {

    override fun map(from: ProfileWithCoffeeAndInfusions): Profile = Profile(
        id = from.profile.id,
        coffee = mapperCoffeeEntityToDomain.map(from.coffee),
        infusions = from.infusions.map { mapperInfusionEntityToDomain.map(it) },
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