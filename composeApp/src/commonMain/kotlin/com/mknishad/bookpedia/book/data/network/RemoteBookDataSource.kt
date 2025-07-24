package com.mknishad.bookpedia.book.data.network

import com.mknishad.bookpedia.book.data.dto.SearchResponseDto
import com.mknishad.bookpedia.core.domain.DataError
import com.mknishad.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String, resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}