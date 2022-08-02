package by.data.di

import by.data.remoteData.RemoteService
import by.data.remoteData.RemoteServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class FireStoreAbstractModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindRemoteService(fireStore: RemoteServiceImpl): RemoteService
}
