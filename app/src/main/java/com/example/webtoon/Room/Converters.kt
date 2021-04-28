package com.example.webtoon.Room

import androidx.room.TypeConverter
import com.example.webtoon.Model.WebToonModel
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: List<WebToonModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<WebToonModel>::class.java).toList()
}