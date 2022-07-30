package by.data.remote.entities

internal data class GroupRemote(
    var id: String? = null,
    var name: String? = null,
    var userIDs: List<String>? = null,
    var profiles: List<ProfileRemote>? = null,
)
