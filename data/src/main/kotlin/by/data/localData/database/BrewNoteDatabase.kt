package by.data.localData.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.data.localData.database.dao.BrewNoteDao
import by.data.localData.database.entity.CoffeeEntity
import by.data.localData.database.entity.InfusionEntity
import by.data.localData.database.entity.ProfileEntity
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Database(entities = [ProfileEntity::class, CoffeeEntity::class, InfusionEntity::class],
    version = 1)
internal abstract class BrewNoteDatabase : RoomDatabase() {

    abstract fun getBrewNoteDao(): BrewNoteDao

    companion object {

        @Synchronized
        fun getBrewNoteDatabase(context: Context): BrewNoteDatabase {
            return Room.databaseBuilder(context, BrewNoteDatabase::class.java, "database").build()
        }
    }
}
