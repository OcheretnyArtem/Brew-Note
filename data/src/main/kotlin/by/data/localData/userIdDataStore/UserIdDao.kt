package by.data.localData.userIdDataStore

import kotlinx.coroutines.flow.Flow


interface UserIdDao {

    suspend fun observeUserId() : Flow<String>

    suspend fun setUserId()
}
