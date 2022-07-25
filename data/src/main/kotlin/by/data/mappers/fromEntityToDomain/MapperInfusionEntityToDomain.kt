package by.data.mappers.fromEntityToDomain

import by.data.database.entity.InfusionEntity
import by.data.mappers.Mapper
import by.domain.entity.Infusion
import javax.inject.Inject

internal class MapperInfusionEntityToDomain @Inject constructor() :
    Mapper<InfusionEntity, Infusion> {

    override fun map(from: InfusionEntity): Infusion = Infusion(
        id = from.id,
        profileId = from.profileId,
        startSecond = from.startSecond,
        endSecond = from.endSecond,
        waitingTime = from.waitingTime,
        countOfWater = from.countOfWater,
        isMixed = from.isMixed
    )
}
