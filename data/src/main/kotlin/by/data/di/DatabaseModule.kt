package by.data.di

import android.content.Context
import by.data.database.BrewNoteDatabase
import by.data.database.dao.BrewNoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InternalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    internal fun provideDatabase(@ApplicationContext context: Context): BrewNoteDatabase =
        BrewNoteDatabase.getBrewNoteDatabase(context)

    @Singleton
    @Provides
    internal fun provideBrewNoteDao(database: BrewNoteDatabase): BrewNoteDao =
        database.getBrewNoteDao()
}
