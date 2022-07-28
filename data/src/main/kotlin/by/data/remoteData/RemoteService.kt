package by.data.remoteData

import by.data.remote.User
import kotlinx.coroutines.flow.Flow


interface RemoteService {

   suspend fun getUsersByName(s: String) : Flow<List<User>>
}