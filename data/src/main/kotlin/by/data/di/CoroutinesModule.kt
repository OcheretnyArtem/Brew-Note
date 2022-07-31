package by.data.di

import by.data.coroutines.DispatcherProviderImpl
import by.domain.coroutines.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoroutinesModule {

    @Binds
    abstract fun provideCoroutineDispatcher(dispatcherProvider: DispatcherProviderImpl): DispatcherProvider
}
