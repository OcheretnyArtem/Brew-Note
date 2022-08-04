package by.data.remoteData.remoteDataBase.entities

import by.data.remoteData.utils.RemoteData

internal data class CoffeeRemote(
    var country: String? = null,
    var region: String? = null,
    var variety: String? = null,
    var processing: String? = null,
    var photo: String? = null,
    var brand: String? = null,
    var description: String? = null,
    var roastDate: String? = null,
) : RemoteData
