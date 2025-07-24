package com.mknishad.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mknishad.bookpedia.core.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Bookpedia",
        ) {
            App()
        }
    }
}