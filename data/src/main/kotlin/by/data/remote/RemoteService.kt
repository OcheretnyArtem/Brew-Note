package by.data.remote

import by.data.remote.entities.GroupRemote
import by.data.remote.entities.ProfileRemote
import by.data.remote.entities.UserRemote
import kotlinx.coroutines.flow.Flow


internal interface RemoteService {

    suspend fun getUsersByName(name: String): Flow<List<UserRemote>>

    suspend fun postProfileInGroup(groupID: String, profile: ProfileRemote)

    suspend fun  deleteProfileFromGroup(groupID: String,  profileID: String)

    suspend fun getUsersByIDs(iDs: List<String>): Flow<List<UserRemote>>

    suspend fun createUser(user: UserRemote)

    suspend fun createGroup(group: GroupRemote)

    suspend fun addUserInGroup(groupID: String, userID: String)

    suspend fun deleteUserFromGroup(groupID: String, userID: String)

    suspend fun getProfilesFromGroup(groupID: String): Flow<List<ProfileRemote>>

    suspend fun getProfileFromGroup(groupID: String, profileID: String): Flow<ProfileRemote>

}
