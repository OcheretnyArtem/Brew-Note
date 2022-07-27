package by.data.parsres.domain

import by.data.database.entity.CoffeeEntity
import by.data.parsres.Parser
import by.domain.entities.Coffee
import javax.inject.Inject

internal class ParserCoffeeDomainEntity @Inject constructor() : Parser<Coffee, CoffeeEntity> {

    override fun pars(from: CoffeeEntity): Coffee = Coffee(
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

    override fun unPars(from: Coffee): CoffeeEntity = CoffeeEntity(
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
