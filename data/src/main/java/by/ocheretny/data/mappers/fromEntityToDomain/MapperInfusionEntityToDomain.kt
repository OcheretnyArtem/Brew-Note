package by.ocheretny.data.mappers.fromEntityToDomain

import by.ocheretny.data.database.entity.InfusionEntity
import by.ocheretny.data.mappers.Mapper
import by.ocheretny.domain.entity.Infusion

internal class MapperInfusionEntityToDomain : Mapper<InfusionEntity, Infusion> {

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