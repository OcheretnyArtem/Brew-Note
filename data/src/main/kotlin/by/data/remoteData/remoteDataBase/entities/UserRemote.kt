package by.data.remoteData.remoteDataBase.entities

import by.data.remoteData.utils.RemoteData

internal data class UserRemote(
    var id: String? = null,
    var name: String? = null,
    var photoURL: String? = null,
    var groupIDs: List<String>? = null,
) : RemoteData
