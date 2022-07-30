package by.domain.entities

data class Group(
    val id: String,
    val name: String,
    val userIDs: List<String>,
    val profiles: List<Profile>,
)
