package com.example.diary.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class QuoteEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val content: String,
    val imagePath: String? = null,
    val emotion: String? = null,
    val timestamp: Long
)