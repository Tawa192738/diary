package com.example.diary.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary_table")
data class DiaryEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val date: Long,
    val imagePath: String? = null,
    val emotion: String? = null,
    val isFavorite: Boolean = false
)