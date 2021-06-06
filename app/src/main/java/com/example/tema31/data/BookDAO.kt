package com.example.tema31.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBook(book: Book )

    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<Book>>
}