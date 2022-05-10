package by.ocheretny.data.di

import by.ocheretny.data.repositories.DatabaseRepositoryImpl
import by.ocheretny.domain.repositories.DatabaseRepository
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