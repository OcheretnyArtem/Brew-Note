package by.domain.dataSoures

import by.domain.entities.Profile
import by.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getUsersByName(name: String): Flow<List<User>>

    suspend fun postProfileInGroup(groupID: String, profile: Profile)

    suspend fun getUsersByIDs(iDs: List<String>) : Flow<List<User>>

}
