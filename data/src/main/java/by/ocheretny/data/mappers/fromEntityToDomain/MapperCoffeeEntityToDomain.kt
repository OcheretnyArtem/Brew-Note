package by.ocheretny.data.mappers.fromEntityToDomain

import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.mappers.Mapper
import by.ocheretny.domain.entity.Coffee
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