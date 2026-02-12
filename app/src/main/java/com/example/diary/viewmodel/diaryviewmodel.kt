package com.example.diary.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.diary.data.entity.DiaryEntry
import com.example.diary.data.repository.DiaryRepository
import kotlinx.coroutines.launch

class DiaryViewModel(private val repository: DiaryRepository) : ViewModel() {

    val allDiaries: LiveData<List<DiaryEntry>> = repository.allDiaries.asLiveData()
    val favoriteDiaries: LiveData<List<DiaryEntry>> = repository.favoriteDiaries.asLiveData()

    fun insert(diary: DiaryEntry) = viewModelScope.launch {
        repository.insert(diary)
    }

    fun delete(diary: DiaryEntry) = viewModelScope.launch {
        repository.delete(diary)
    }

    fun update(diary: DiaryEntry) = viewModelScope.launch {
        repository.update(diary)
    }

    fun search(query: String): LiveData<List<DiaryEntry>> {
        return repository.search(query).asLiveData()
    }
}

