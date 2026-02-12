package com.example.diary.data.dao

import androidx.room.*
import com.example.diary.data.entity.QuoteEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: QuoteEntry)

    @Delete
    suspend fun deleteQuote(quote: QuoteEntry)

    @Query("SELECT * FROM quote_table ORDER BY timestamp DESC")
    fun getAllQuotes(): Flow<List<QuoteEntry>>

    @Query("SELECT * FROM quote_table ORDER BY RANDOM() LIMIT 1")
    fun getRandomQuote(): Flow<QuoteEntry?>
}