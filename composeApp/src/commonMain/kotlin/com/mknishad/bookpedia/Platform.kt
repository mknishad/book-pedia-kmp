package com.mknishad.bookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform