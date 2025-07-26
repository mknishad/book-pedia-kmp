package com.mknishad.bookpedia.book.domain

import com.mknishad.bookpedia.core.domain.DataError
import com.mknishad.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
}