package by.data.remote.entities

import by.data.remote.utils.RemoteData

data class Infusion(
    var id: Int? = null,
    var profileId: Int? = null,
    var startSecond: Int? = null,
    var endSecond: Int? = null,
    var waitingTime: Int? = null,
    var countOfWater: Int? = null,
    var isMixed: Boolean? = null,
) : RemoteData
