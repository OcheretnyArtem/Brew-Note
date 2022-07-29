package by.data.remote.entities

data class Coffee(
    var id: Int? = null,
    val country: String? = null,
    val region: String? = null,
    val variety: String? = null,
    val processing: String? = null,
    val photo: String? = null,
    val brand: String? = null,
    val description: String? = null,
    val roastDate: String? = null,
) : RemoteData
