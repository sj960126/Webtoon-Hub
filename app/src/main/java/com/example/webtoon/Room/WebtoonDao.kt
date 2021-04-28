package com.example.webtoon.Room

import retrofit2.http.Query

interface WebtoonDao {
    @Query("select * from tool_table where id = :toolId")
    fun find(toolId: String): ToolEntity
}