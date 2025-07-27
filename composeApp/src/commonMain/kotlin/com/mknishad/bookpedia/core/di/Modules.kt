package com.mknishad.bookpedia.core.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.mknishad.bookpedia.book.data.database.DatabaseFactory
import com.mknishad.bookpedia.book.data.database.FavoriteBookDatabase
import com.mknishad.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.mknishad.bookpedia.book.data.network.RemoteBookDataSource
import com.mknishad.bookpedia.book.data.repository.DefaultBookRepository
import com.mknishad.bookpedia.book.domain.BookRepository
import com.mknishad.bookpedia.book.presentation.SelectedBookViewModel
import com.mknishad.bookpedia.book.presentation.bookdetail.BookDetailViewModel
import com.mknishad.bookpedia.book.presentation.booklist.BookListViewModel
import com.mknishad.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}