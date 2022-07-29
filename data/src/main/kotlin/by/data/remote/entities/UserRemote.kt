package by.data.remote.entities

import by.data.remote.utils.RemoteData

internal data class UserRemote(
    var name: String? = null,
    var photoURL: String? = null,

) : RemoteData
