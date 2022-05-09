package by.ocheretny.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.database.entity.InfusionEntity
import by.ocheretny.data.database.entity.ProfileEntity

internal data class ProfileWithCoffeeAndInfusions(
    @Embedded val profile: ProfileEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val coffee: CoffeeEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val infusions: List<InfusionEntity> = emptyList()
)