package by.domain.dataSoures

import by.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getUsersByName(name: String): Flow<List<User>>

}
