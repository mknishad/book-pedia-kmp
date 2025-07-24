package com.mknishad.bookpedia

import androidx.compose.runtime.Composable
import com.mknishad.bookpedia.book.presentation.booklist.BookListScreenRoot
import com.mknishad.bookpedia.book.presentation.booklist.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = koinViewModel<BookListViewModel>(),
        onBookClick = {}
    )
}