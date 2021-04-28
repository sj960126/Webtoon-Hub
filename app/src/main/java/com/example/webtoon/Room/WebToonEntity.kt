package com.example.webtoon.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.webtoon.Model.WebToonModel

@Entity
data class WebToonEntity(
    @PrimaryKey val no: String,
    @ColumnInfo(name = "list") var WebtoonList: List<WebToonModel> ? =null
)