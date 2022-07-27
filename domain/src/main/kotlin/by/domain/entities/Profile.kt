package by.domain.entities

data class Profile(
    var id: Int? = null,
    val coffee: Coffee,
    val infusions: List<Infusion> = emptyList(),
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
