package com.example.diary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.diary.data.dao.DiaryDao
import com.example.diary.data.dao.QuoteDao
import com.example.diary.data.entity.DiaryEntry
import com.example.diary.data.entity.QuoteEntry

@Database(entities = [DiaryEntry::class, QuoteEntry::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Khai báo các hàm để lấy DAO
    abstract fun diaryDao(): DiaryDao
    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "diary_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}