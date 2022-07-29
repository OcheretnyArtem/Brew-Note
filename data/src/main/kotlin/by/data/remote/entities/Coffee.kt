package by.data.remote.entities

import by.data.remote.utils.RemoteData

data class Coffee(
    var id: Int? = null,
    var country: String? = null,
    var region: String? = null,
    var variety: String? = null,
    var processing: String? = null,
    var photo: String? = null,
    var brand: String? = null,
    var description: String? = null,
    var roastDate: String? = null,
) : RemoteData
