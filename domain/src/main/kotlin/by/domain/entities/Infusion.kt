package by.domain.entities

data class Infusion(
    var id: Int? = null,
    var profileId: Int? = null,
    val startSecond: Int,
    val endSecond: Int,
    val waitingTime: Int,
    val countOfWater: Int,
    val isMixed: Boolean
)
