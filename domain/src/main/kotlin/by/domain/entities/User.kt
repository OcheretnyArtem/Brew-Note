package by.domain.entities

data class User(
    val name: String,
    val photoURL: String,
    val groupIDs: List<String>,
)
