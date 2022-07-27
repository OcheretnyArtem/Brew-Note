package by.ocheretny.brewnote.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfusionUI(
    var id: Int? = null,
    val profileId: Int,
    val startSecond: Int,
    val endSecond: Int,
    val waitingTime: Int,
    val countOfWater: Int,
    val isMixed: Boolean
) : Parcelable
