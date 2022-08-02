package by.domain.dataSoures

import by.domain.entities.Profile
import by.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getUsersByName(name: String): Flow<List<User>>

    suspend fun postProfileInGroup(groupID: String, profile: Profile)

    suspend fun  deleteProfileFromGroup(groupID: String, profileID: String)

    suspend fun getUsersByIDs(iDs: List<String>) : Flow<List<User>>

    suspend fun createUser(user: User)

    suspend fun addUserInGroup(groupID: String, userID: String)

    suspend fun deleteUserFromGroup(groupID: String, userID: String)

    suspend fun getProfilesFromGroup(groupID: String): Flow<List<Profile>>

    suspend fun getProfileFromGroup(groupID: String, profileID: String): Flow<Profile>

}
