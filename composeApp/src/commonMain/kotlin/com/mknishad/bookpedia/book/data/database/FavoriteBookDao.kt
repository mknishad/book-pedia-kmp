package com.mknishad.bookpedia.book.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteBookDao {
    @Query("SELECT * FROM bookentity")
    fun getAllFavoriteBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM bookentity WHERE id = :id")
    suspend fun getFavoriteBook(id: String): BookEntity?

    @Upsert
    suspend fun addToFavorite(book: BookEntity)

    @Delete
    suspend fun deleteFavoriteBook(book: BookEntity)
}