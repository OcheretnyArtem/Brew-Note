package by.data.mappers.fromDomainToEntity

import by.data.database.entity.CoffeeEntity
import by.data.mappers.Mapper
import by.domain.entity.Coffee
import javax.inject.Inject

internal class MapperCoffeeDomainToEntity @Inject constructor() : Mapper<Coffee, CoffeeEntity> {

    override fun map(from: Coffee): CoffeeEntity = CoffeeEntity(
        country = from.country,
        region = from.region,
        variety = from.variety,
        processing = from.processing,
        photo = from.photo,
        description = from.description,
        brand = from.brand,
        roastDate = from.roastDate
    )
}
