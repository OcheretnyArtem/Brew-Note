package by.data.remote.entities

data class Profile(
    var id: Int? = null,
    val coffeeId: Int? = null,
    val device: String? = null,
    val totalTime: Double? = null,
    val totalWaterWeight: Double? = null,
    val waterTemperature: Double? = null,
    val dryCoffeeWeight: Double? = null,
    val grinderName: String? = null,
    val grinderSetting: Double? = null,
    var description: String? = null,
    var brewedCoffeeWeight: Double? = null,
    var tds: Double? = null,
    var extraction: Double? = null,
) : RemoteData
