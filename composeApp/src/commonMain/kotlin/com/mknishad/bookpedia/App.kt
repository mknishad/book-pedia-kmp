package com.mknishad.bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mknishad.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.mknishad.bookpedia.book.data.repository.DefaultBookRepository
import com.mknishad.bookpedia.book.presentation.booklist.BookListScreenRoot
import com.mknishad.bookpedia.book.presentation.booklist.BookListViewModel
import com.mknishad.bookpedia.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(engine)
                    )
                )
            )
        },
        onBookClick = {}
    )
}