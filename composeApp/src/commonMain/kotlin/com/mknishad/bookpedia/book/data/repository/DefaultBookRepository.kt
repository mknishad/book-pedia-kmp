package com.mknishad.bookpedia.book.data.repository

import androidx.sqlite.SQLiteException
import com.mknishad.bookpedia.book.data.database.FavoriteBookDao
import com.mknishad.bookpedia.book.data.mappers.toBook
import com.mknishad.bookpedia.book.data.mappers.toBookEntity
import com.mknishad.bookpedia.book.data.network.RemoteBookDataSource
import com.mknishad.bookpedia.book.domain.Book
import com.mknishad.bookpedia.book.domain.BookRepository
import com.mknishad.bookpedia.core.domain.DataError
import com.mknishad.bookpedia.core.domain.EmptyResult
import com.mknishad.bookpedia.core.domain.Result
import com.mknishad.bookpedia.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError.Remote> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)

        if (localResult == null) {
            return remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            return Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getAllFavoriteBooks()
            .map { entities ->
                entities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getAllFavoriteBooks()
            .map { entities ->
                entities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.addToFavorite(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(book: Book) {
        favoriteBookDao.deleteFavoriteBook(book.toBookEntity())
    }
}
