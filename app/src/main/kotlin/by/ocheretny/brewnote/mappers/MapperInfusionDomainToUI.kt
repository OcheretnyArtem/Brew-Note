package by.ocheretny.brewnote.mappers

import by.data.parsres.Mapper
import by.domain.entities.Infusion
import by.ocheretny.brewnote.entities.InfusionUI
import javax.inject.Inject

internal class MapperInfusionDomainToUI @Inject constructor() : Mapper<Infusion, InfusionUI> {

    override fun map(from: Infusion): InfusionUI = InfusionUI(
        id = from.id,
        profileId = from.profileId,
        endSecond = from.endSecond,
        startSecond = from.startSecond,
        waitingTime = from.waitingTime,
        countOfWater = from.countOfWater,
        isMixed = from.isMixed
    )
}

