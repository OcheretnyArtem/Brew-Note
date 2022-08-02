package by.data.parsres.remoteData

import by.data.parsres.Parser
import by.data.remoteData.entities.CoffeeRemote
import by.domain.entities.Coffee
import javax.inject.Inject

internal class ParserCoffeeDomainRemote @Inject constructor() : Parser<Coffee, CoffeeRemote> {

    override fun pars(from: CoffeeRemote): Coffee = Coffee(
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
