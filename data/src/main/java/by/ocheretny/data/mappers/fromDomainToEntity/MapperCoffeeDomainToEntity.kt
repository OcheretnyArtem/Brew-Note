package by.ocheretny.data.mappers.fromDomainToEntity

import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.mappers.Mapper
import by.ocheretny.domain.entity.Coffee

internal class MapperCoffeeDomainToEntity : Mapper<Coffee, CoffeeEntity> {

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