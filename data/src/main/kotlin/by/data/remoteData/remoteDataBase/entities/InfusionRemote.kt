package by.data.remoteData.remoteDataBase.entities

import by.data.remoteData.utils.RemoteData

internal data class InfusionRemote(
    var startSecond: Int? = null,
    var endSecond: Int? = null,
    var waitingTime: Int? = null,
    var countOfWater: Int? = null,
    var isMixed: Boolean? = null,
) : RemoteData
