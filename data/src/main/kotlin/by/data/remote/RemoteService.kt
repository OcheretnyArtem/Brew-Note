package by.data.remote

import by.data.remote.entities.ProfileRemote
import by.data.remote.entities.UserRemote
import kotlinx.coroutines.flow.Flow


internal interface RemoteService {

    suspend fun getUsersByName(name: String): Flow<List<UserRemote>>

    suspend fun getProfilesFromGroup(groupID: String): Flow<List<ProfileRemote>>

    suspend fun getProfileFromGroup(groupID: String, profileID: String): Flow<ProfileRemote>

    suspend fun getUsersByIDs(iDs: List<String>): Flow<List<UserRemote>>

    suspend fun postProfileInGroup(groupID: String, profile: ProfileRemote)

    suspend fun createUser(user: UserRemote)

    suspend fun addUserInGroup(groupID: String, userID: String)

}
