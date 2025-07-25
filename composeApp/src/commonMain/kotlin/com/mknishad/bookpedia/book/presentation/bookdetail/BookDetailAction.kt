package com.mknishad.bookpedia.book.presentation.bookdetail

import com.mknishad.bookpedia.book.domain.Book

interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}