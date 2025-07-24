package com.mknishad.bookpedia.book.presentation.booklist

import com.mknishad.bookpedia.book.domain.Book
import com.mknishad.bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        authors = listOf("Author $it"),
        imageUrl = "https://picsum.photos/200/300?random=$it",
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.567,
        ratingCount = 5,
        numPages = 100,
        numEditions = 3
    )
}