package by.data.di

import by.data.localData.dataStores.userID.UserIdDao
import by.data.localData.dataStores.userID.UserIdDaoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InternalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

    @Binds
    @Singleton
    internal abstract fun bindUserIdDao(userIdDataStore: UserIdDaoImpl):
            UserIdDao
}
