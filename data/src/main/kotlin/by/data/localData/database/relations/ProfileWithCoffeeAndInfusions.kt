package by.data.localData.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import by.data.localData.database.entity.CoffeeEntity
import by.data.localData.database.entity.InfusionEntity
import by.data.localData.database.entity.ProfileEntity

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
