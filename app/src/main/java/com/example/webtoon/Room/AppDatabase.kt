package com.example.webtoon.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(AppDatabase::class), version = 4)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){

}


