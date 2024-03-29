package by.data.parsres.remoteData

import by.data.parsres.Parser
import by.data.remoteData.remoteDataBase.entities.InfusionRemote
import by.domain.entities.Infusion
import javax.inject.Inject

internal class ParserInfusionDomainRemote @Inject constructor() : Parser<Infusion, InfusionRemote> {

    override fun pars(from: InfusionRemote): Infusion = Infusion(
        startSecond = from.startSecond ?: 0,
        endSecond = from.endSecond ?: 0,
        waitingTime = from.waitingTime ?: 0,
        countOfWater = from.countOfWater ?: 0,
        isMixed = from.isMixed ?: false
    )

    override fun unPars(from: Infusion): InfusionRemote = InfusionRemote(
        startSecond = from.startSecond,
        endSecond = from.endSecond,
        waitingTime = from.waitingTime,
        countOfWater = from.countOfWater,
        isMixed = from.isMixed
    )
}
