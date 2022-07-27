package by.ocheretny.brewnote.mappers

import by.data.parsres.Mapper
import by.domain.entities.Coffee
import by.ocheretny.brewnote.entities.CoffeeUI
import javax.inject.Inject

internal class MapperCoffeeDomainToUI @Inject constructor() : Mapper<Coffee, CoffeeUI> {

    override fun map(from: Coffee): CoffeeUI = CoffeeUI(
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
