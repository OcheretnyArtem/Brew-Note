package by.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffee(
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