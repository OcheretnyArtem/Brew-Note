package by.data.remote.entities

import by.data.remote.utils.RemoteData

data class User(
    var name: String? = null,
    var photoURL: String? = null,

) : RemoteData
