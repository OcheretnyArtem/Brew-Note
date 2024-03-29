package by.data.parsres.localData

import by.data.localData.database.entity.ProfileEntity
import by.data.parsres.Mapper
import by.domain.entities.Profile
import javax.inject.Inject

internal class MapperProfileDomainToEntity @Inject constructor() : Mapper<Profile, ProfileEntity> {

    override fun map(from: Profile): ProfileEntity {
        return with(from) {
            ProfileEntity(
                coffeeId = coffee.id!!,
                device = device,
                totalTime = totalTime,
                totalWaterWeight = totalWaterWeight,
                waterTemperature = waterTemperature,
                dryCoffeeWeight = dryCoffeeWeight,
                grinderName = grinderName,
                grinderSetting = grinderSetting,
                description = description,
                brewedCoffeeWeight = brewedCoffeeWeight,
                tds = tds,
                extraction = extraction
            )
        }
    }
}
