package com.mknishad.bookpedia.book.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object StringListTypeConverter {
    @TypeConverter
    fun fromList(value: List<String>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun fromString(value: String): List<String> {
        return Json.decodeFromString(value)
    }
}
