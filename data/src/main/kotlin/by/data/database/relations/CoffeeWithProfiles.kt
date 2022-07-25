package by.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import by.data.database.entity.CoffeeEntity
import by.data.database.entity.ProfileEntity

internal data class CoffeeWithProfiles(
    @Embedded val coffee: CoffeeEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "coffeeId"
    )
    val profiles: List<ProfileEntity> = emptyList()
)
