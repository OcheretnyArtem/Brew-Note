package by.data.remote.entities

data class Infusion(
    var id: Int? = null,
    val profileId: Int? = null,
    val startSecond: Int? = null,
    val endSecond: Int? = null,
    val waitingTime: Int? = null,
    val countOfWater: Int? = null,
    val isMixed: Boolean? = null,
) : RemoteData
