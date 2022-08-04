package by.data.remoteData.remoteDataBase

import by.data.remoteData.remoteDataBase.entities.GroupRemote
import by.data.remoteData.remoteDataBase.entities.ProfileRemote
import by.data.remoteData.remoteDataBase.entities.UserRemote
import kotlinx.coroutines.flow.Flow


internal interface RemoteService {

    suspend fun getUsersByName(name: String): Flow<List<UserRemote>>

    suspend fun postProfileInGroup(groupID: String, profile: ProfileRemote)

    suspend fun deleteProfileFromGroup(groupID: String, profileID: String)

    suspend fun getUsersByIDs(iDs: List<String>): Flow<List<UserRemote>>

    suspend fun createUser(user: UserRemote, userID: String)

    suspend fun createGroup(userID: String, group: GroupRemote)

    suspend fun addUserInGroup(groupID: String, userID: String)

    suspend fun deleteUserFromGroup(groupID: String, userID: String)

    suspend fun getProfilesFromGroup(groupID: String): Flow<List<ProfileRemote>>

    suspend fun getProfileFromGroup(groupID: String, profileID: String): Flow<ProfileRemote>

}
