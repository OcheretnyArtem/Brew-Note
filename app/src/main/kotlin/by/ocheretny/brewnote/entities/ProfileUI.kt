package by.ocheretny.brewnote.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileUI(
    var id: Int? = null,
    val coffee: CoffeeUI,
    val infusions: List<InfusionUI> = emptyList(),
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
) : Parcelable
