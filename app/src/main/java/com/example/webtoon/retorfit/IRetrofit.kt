package com.example.webtoon.retorfit

import com.example.webtoon.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {
    @GET(API.WebToon_URL) //μΆκ°λλ url
    fun searcWebToon(@Query("weeknum") searchTerm: String): Call<JsonElement>
    //https://toy-projects-api.herokuapp.com/webtoon/info
}