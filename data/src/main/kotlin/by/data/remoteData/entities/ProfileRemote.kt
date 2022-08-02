package by.data.remoteData.entities

import by.data.remoteData.utils.RemoteData

internal data class ProfileRemote(
    var id: String? = null,
    var coffee: CoffeeRemote? = null,
    var infusions: List<InfusionRemote>? = null,
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
