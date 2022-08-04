package by.data.parsres.remoteData

import by.data.parsres.Parser
import by.data.remoteData.remoteDataBase.entities.CoffeeRemote
import by.data.remoteData.remoteDataBase.entities.InfusionRemote
import by.data.remoteData.remoteDataBase.entities.ProfileRemote
import by.domain.entities.Coffee
import by.domain.entities.Infusion
import by.domain.entities.Profile
import javax.inject.Inject

internal class ParserProfileDomainRemote @Inject constructor(
    private val coffeeParser: Parser<Coffee, CoffeeRemote>,
    private val infusionParser: Parser<Infusion, InfusionRemote>,
) : Parser<Profile, ProfileRemote> {

    override fun pars(from: ProfileRemote): Profile = Profile(
        remoteId = from.id,
        coffee = coffeeParser.pars(from.coffee!!),
        infusions = from.infusions?.map { infusionParser.pars(it) } ?: emptyList(),
        device = from.device.orEmpty(),
        totalTime = from.totalTime ?: 0.0,
        totalWaterWeight = from.totalWaterWeight ?: 0.0,
        waterTemperature = from.waterTemperature ?: 0.0,
        dryCoffeeWeight = from.dryCoffeeWeight ?: 0.0,
        grinderName = from.grinderName.orEmpty(),
        grinderSetting = from.grinderSetting ?: 0.0,
        description = from.description,
        brewedCoffeeWeight = from.brewedCoffeeWeight,
        tds = from.tds,
        extraction = from.extraction
    )

    override fun unPars(from: Profile): ProfileRemote = ProfileRemote(
        coffee = coffeeParser.unPars(from.coffee),
        infusions = from.infusions.map { infusionParser.unPars(it) },
        device = from.device,
        totalTime = from.totalTime,
        totalWaterWeight = from.totalWaterWeight,
        waterTemperature = from.waterTemperature,
        dryCoffeeWeight = from.dryCoffeeWeight,
        grinderSetting = from.grinderSetting,
        grinderName = from.grinderName,
        description = from.description,
        brewedCoffeeWeight = from.brewedCoffeeWeight,
        tds = from.tds,
    )
}
