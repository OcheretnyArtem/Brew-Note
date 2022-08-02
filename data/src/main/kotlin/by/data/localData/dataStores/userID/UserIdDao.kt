package by.data.localData.dataStores.userID

import kotlinx.coroutines.flow.Flow


interface UserIdDao {

    suspend fun observeUserId(): Flow<String>

    suspend fun setUserId(id: String)
}
