package by.ocheretny.brewnote.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoffeeUI(
    var id: Int? = null,
    val country: String,
    val region: String,
    val variety: String,
    val processing: String,
    val photo: String? = null,
    val brand: String,
    val description: String? = null,
    val roastDate: String,
) : Parcelable
