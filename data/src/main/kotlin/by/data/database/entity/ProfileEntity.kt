package by.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
internal data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val coffeeId: Int,
    val device: String,
    val totalTime: Double,
    val totalWaterWeight: Double,
    val waterTemperature: Double,
    val dryCoffeeWeight: Double,
    val grinderName: String,
    val grinderSetting: Double,
    var description: String? = null,
    var brewedCoffeeWeight: Double? = null,
    var tds: Double? = null,
    var extraction: Double? = null,
)
