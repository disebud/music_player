package com.example.enigmamusicplayer.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enigmamusicplayer.room.music.Album
import com.example.enigmamusicplayer.room.music.MusicDao
import com.example.enigmamusicplayer.room.music.Song


@Database(entities = [Album::class, Song::class], version = 1)

abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) DATABASE_INSTANCE as AppRoomDatabase

            DATABASE_INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "enigma_music"
            ).fallbackToDestructiveMigration().build()

            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}
