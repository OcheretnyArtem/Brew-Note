package by.data.remote.entities

import by.data.remote.utils.RemoteData

internal data class UserRemote(
    var id: String? = null,
    var name: String? = null,
    var photoURL: String? = null,
    var groupIDs: List<String>? = null,
) : RemoteData
