package by.ocheretny.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "infusion_table")
internal data class InfusionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val profileId: Int,
    val startSecond: Int,
    val endSecond: Int,
    val waitingTime: Int,
    val countOfWater: Int,
    val isMixed: Boolean = false
)
