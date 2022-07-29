package by.data.remote.entities

import by.data.remote.utils.RemoteData

internal data class ProfileRemote(
    var id: Int? = null,
    var coffeeId: Int? = null,
    var device: String? = null,
    var totalTime: Double? = null,
    var totalWaterWeight: Double? = null,
    var waterTemperature: Double? = null,
    var dryCoffeeWeight: Double? = null,
    var grinderName: String? = null,
    var grinderSetting: Double? = null,
    var description: String? = null,
    var brewedCoffeeWeight: Double? = null,
    var tds: Double? = null,
    var extraction: Double? = null,
) : RemoteData
