package by.ocheretny.domain.entity

data class Infusion(
    var id: Int? = null,
    val profileId: String,
    val startSecond: Int,
    val endSecond: Int,
    val waitingTime: Int,
    val countOfWater: Int,
    val isMixed: Boolean
)
