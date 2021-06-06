package com.example.tema31.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val author:String,
    val description:String
)