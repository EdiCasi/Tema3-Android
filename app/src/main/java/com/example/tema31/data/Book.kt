package com.example.tema31.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "book_table")
data class Book (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val author:String,
    val description:String
):Parcelable