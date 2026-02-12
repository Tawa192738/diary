package com.example.diary.viewmodel

import androidx.lifecycle.*
import com.example.diary.data.entity.QuoteEntry
import com.example.diary.data.repository.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    val allQuotes: LiveData<List<QuoteEntry>> = repository.allQuotes.asLiveData()
    val randomQuote: LiveData<QuoteEntry?> = repository.randomQuote.asLiveData()

    fun insert(quote: QuoteEntry) = viewModelScope.launch {
        repository.insert(quote)
    }

    fun delete(quote: QuoteEntry) = viewModelScope.launch {
        repository.delete(quote)
    }
}