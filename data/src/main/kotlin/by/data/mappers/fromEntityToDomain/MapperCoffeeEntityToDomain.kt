package by.data.mappers.fromEntityToDomain

import by.data.database.entity.CoffeeEntity
import by.data.mappers.Mapper
import by.domain.entity.Coffee
import javax.inject.Inject

internal class MapperCoffeeEntityToDomain @Inject constructor() : Mapper<CoffeeEntity, Coffee> {

    override fun map(from: CoffeeEntity): Coffee = Coffee(
        id = from.id,
        country = from.country,
        region = from.region,
        variety = from.variety,
        processing = from.processing,
        photo = from.photo,
        brand = from.brand,
        description = from.description,
        roastDate = from.roastDate
    )
}
