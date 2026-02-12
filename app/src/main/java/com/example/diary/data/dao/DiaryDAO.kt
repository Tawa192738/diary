package com.example.diary.data.dao
import androidx.room.*
import com.example.diary.data.entity.DiaryEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiary(diary: DiaryEntry)

    @Update
    suspend fun update(diary: DiaryEntry)

    @Delete
    suspend fun deleteDiary(diary: DiaryEntry)

    @Query("SELECT * FROM diary_table ORDER BY date DESC")
    fun getAllDiaries(): Flow<List<DiaryEntry>>

    @Query("SELECT * FROM diary_table WHERE isFavorite = 1 ORDER BY date DESC")
    fun getFavoriteDiaries(): Flow<List<DiaryEntry>>

    @Query("SELECT * FROM diary_table WHERE title LIKE :searchQuery OR content LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<DiaryEntry>>
}