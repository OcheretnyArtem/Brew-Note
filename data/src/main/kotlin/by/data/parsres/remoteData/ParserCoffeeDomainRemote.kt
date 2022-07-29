package by.data.parsres.remoteData

import by.data.parsres.Parser
import by.data.remote.entities.CoffeeRemote
import by.domain.entities.Coffee

internal class ParserCoffeeDomainRemote : Parser<Coffee, CoffeeRemote> {

    override fun pars(from: CoffeeRemote): Coffee = Coffee(
        id = from.id,
        country = from.country.orEmpty(),
        region = from.region.orEmpty(),
        variety = from.variety.orEmpty(),
        processing = from.processing.orEmpty(),
        photo = from.photo.orEmpty(),
        brand = from.brand.orEmpty(),
        description = from.description,
        roastDate = from.roastDate.orEmpty()
    )

    override fun unPars(from: Coffee): CoffeeRemote = CoffeeRemote(
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
