package by.domain.entities

data class User(
    var id : String? = null,
    val name: String,
    val photoURL: String,
    val groupIDs: List<String>,
)
