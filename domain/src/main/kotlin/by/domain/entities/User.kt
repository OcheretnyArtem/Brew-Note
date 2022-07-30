package by.domain.entities

data class User(
    val id: String,
    val name: String,
    val photoURL: String,
    val groupIDs: List<String>,
)
