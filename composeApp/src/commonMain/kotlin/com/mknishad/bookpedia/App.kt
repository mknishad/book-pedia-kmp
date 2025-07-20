package com.mknishad.bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mknishad.bookpedia.book.presentation.booklist.BookListScreenRoot
import com.mknishad.bookpedia.book.presentation.booklist.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreenRoot(viewModel = remember { BookListViewModel() }, onBookClick = {})
}