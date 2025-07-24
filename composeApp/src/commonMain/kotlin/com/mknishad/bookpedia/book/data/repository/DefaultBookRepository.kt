package com.mknishad.bookpedia.book.data.repository

import com.mknishad.bookpedia.book.data.mappers.toBook
import com.mknishad.bookpedia.book.data.network.RemoteBookDataSource
import com.mknishad.bookpedia.book.domain.Book
import com.mknishad.bookpedia.book.domain.BookRepository
import com.mknishad.bookpedia.core.domain.DataError
import com.mknishad.bookpedia.core.domain.Result
import com.mknishad.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}