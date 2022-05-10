package by.ocheretny.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.ocheretny.data.database.dao.BrewNoteDao
import by.ocheretny.data.database.entity.CoffeeEntity
import by.ocheretny.data.database.entity.InfusionEntity
import by.ocheretny.data.database.entity.ProfileEntity
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
