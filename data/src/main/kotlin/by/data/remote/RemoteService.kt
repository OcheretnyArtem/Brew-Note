package by.data.remote

import by.data.remote.entities.UserRemote
import kotlinx.coroutines.flow.Flow


interface RemoteService {

   suspend fun getUsersByName(s: String) : Flow<List<UserRemote>>
}