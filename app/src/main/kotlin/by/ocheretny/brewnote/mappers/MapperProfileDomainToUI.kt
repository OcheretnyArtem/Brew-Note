package by.ocheretny.brewnote.mappers

import by.data.parsres.Mapper
import by.domain.entities.Coffee
import by.domain.entities.Infusion
import by.domain.entities.Profile
import by.ocheretny.brewnote.entities.CoffeeUI
import by.ocheretny.brewnote.entities.InfusionUI
import by.ocheretny.brewnote.entities.ProfileUI
import javax.inject.Inject

internal class MapperProfileDomainToUI @Inject constructor(
    private val mapperCoffeeDomainToUI: Mapper<Coffee, CoffeeUI>,
    private val mapperInfusionDomainToUI: Mapper<Infusion, InfusionUI>,
) : Mapper<Profile, ProfileUI> {

    override fun map(from: Profile): ProfileUI = ProfileUI(
        id = from.id,
        coffee = mapperCoffeeDomainToUI.map(from.coffee),
        infusions = from.infusions.map { infusion -> mapperInfusionDomainToUI.map(infusion) },
        device = from.device,
        totalTime = from.totalTime,
        totalWaterWeight = from.totalWaterWeight,
        waterTemperature = from.waterTemperature,
        dryCoffeeWeight = from.dryCoffeeWeight,
        grinderName = from.grinderName,
        grinderSetting = from.grinderSetting,
        description = from.description,
        brewedCoffeeWeight = from.brewedCoffeeWeight,
        tds = from.tds,
        extraction = from.extraction
    )
}
