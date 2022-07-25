package by.data.di

import by.data.repositories.DatabaseRepositoryImpl
import by.domain.repositories.DatabaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InternalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    internal abstract fun bindBrewNoteRepository(databaseRepositoryImpl: DatabaseRepositoryImpl):
            DatabaseRepository
}
