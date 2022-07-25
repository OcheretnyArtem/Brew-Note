package by.data.mappers.fromDomainToEntity

import by.data.database.entity.InfusionEntity
import by.data.mappers.Mapper
import by.domain.entity.Infusion
import javax.inject.Inject

internal class MapperInfusionDomainToEntity @Inject constructor() :
    Mapper<Infusion, InfusionEntity> {

    override fun map(from: Infusion): InfusionEntity = InfusionEntity(
        profileId = from.profileId,
        startSecond = from.startSecond,
        endSecond = from.endSecond,
        waitingTime = from.waitingTime,
        countOfWater = from.countOfWater,
        isMixed = from.isMixed
    )

}
