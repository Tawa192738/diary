package com.example.diary.data.repository

import com.example.diary.data.dao.QuoteDao
import com.example.diary.data.entity.QuoteEntry
import kotlinx.coroutines.flow.Flow

class QuoteRepository(private val quoteDao: QuoteDao) {

    val allQuotes: Flow<List<QuoteEntry>> = quoteDao.getAllQuotes()

    suspend fun insert(quote: QuoteEntry) {
        quoteDao.insertQuote(quote)
    }

    suspend fun delete(quote: QuoteEntry) {
        quoteDao.deleteQuote(quote)
    }

    val randomQuote: Flow<QuoteEntry?> = quoteDao.getRandomQuote()
}