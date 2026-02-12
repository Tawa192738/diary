package com.example.diary.data.repository

import com.example.diary.data.dao.DiaryDao
import com.example.diary.data.entity.DiaryEntry
import kotlinx.coroutines.flow.Flow

class DiaryRepository(private val diaryDao: DiaryDao) {

    val allDiaries: Flow<List<DiaryEntry>> = diaryDao.getAllDiaries()

    val favoriteDiaries: Flow<List<DiaryEntry>> = diaryDao.getFavoriteDiaries()

    suspend fun insert(diary: DiaryEntry) {
        diaryDao.insertDiary(diary)
    }

    suspend fun delete(diary: DiaryEntry) {
        diaryDao.deleteDiary(diary)
    }

    suspend fun update(diary: DiaryEntry) {
        diaryDao.update(diary)
    }
    fun search(query: String): Flow<List<DiaryEntry>> {
        return diaryDao.searchDatabase("%$query%")
    }

}