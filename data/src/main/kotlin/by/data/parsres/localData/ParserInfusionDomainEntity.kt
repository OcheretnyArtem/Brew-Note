package by.data.parsres.localData

import by.data.localData.database.entity.InfusionEntity
import by.data.parsres.Parser
import by.domain.entities.Infusion
import javax.inject.Inject

internal class ParserInfusionDomainEntity @Inject constructor() : Parser<Infusion, InfusionEntity> {

    override fun pars(from: InfusionEntity): Infusion = Infusion(
        id = from.id,
        profileId = from.profileId,
        startSecond = from.startSecond,
        endSecond = from.endSecond,
        waitingTime = from.waitingTime,
        countOfWater = from.countOfWater,
        isMixed = from.isMixed
    )

    override fun unPars(from: Infusion): InfusionEntity = InfusionEntity(
        profileId = from.profileId!!,
        startSecond = from.startSecond,
        endSecond = from.endSecond,
        waitingTime = from.waitingTime,
        countOfWater = from.countOfWater,
        isMixed = from.isMixed
    )


}
