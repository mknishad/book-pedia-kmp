package com.mknishad.bookpedia.book.presentation.bookdetail

import com.mknishad.bookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
