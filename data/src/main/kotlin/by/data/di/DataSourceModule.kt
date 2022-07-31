package by.data.di

import by.data.dataSources.LocalDataSourceImpl
import by.data.dataSources.RemoteDataSourceImpl
import by.domain.dataSoures.LocalDataSource
import by.domain.dataSoures.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindLocalDataSource(localDataSource: LocalDataSourceImpl):
            LocalDataSource

    @Binds
    @ViewModelScoped
    internal abstract fun bindRemoteDataSourceImpl(fireStore: RemoteDataSourceImpl):
            RemoteDataSource
}
