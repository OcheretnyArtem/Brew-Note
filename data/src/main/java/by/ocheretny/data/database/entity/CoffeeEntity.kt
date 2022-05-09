package by.ocheretny.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_table")
internal data class CoffeeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val country: String,
    val region: String,
    val variety: String,
    val processing: String,
    val photo: String? = null,
    val brand: String,
    val description: String? = null,
    val roastDate: String,
)