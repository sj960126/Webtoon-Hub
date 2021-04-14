package com.example.webtoon.retorfit

import android.util.Log
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.utils.API
import com.example.webtoon.utils.Constants.TAG
import com.example.webtoon.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object{
        val instance = RetrofitManager()
    }

    //http Call
    // 레트로핏 인터페이스 가져오기
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    //웹툰 검색 api 호출
    fun searchWebtoon(searchTerm: String?, completion: (RESPONSE_STATE,ArrayList<WebToonModel>?) -> Unit) {
        val term = searchTerm.let {
            it //옵셔널 언래핑
        }?: ""

        val call  = iRetrofit?.searcWebToon(searchTerm = term).let {
            it
        }?: return //값이 없다면 리턴

        call.enqueue(object : retrofit2.Callback<JsonElement>{ //api 호출
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG,"응답성공${response.raw()}")

                when(response.code()) { //응답 코드
                    200 -> { //성공 코
                        response.body()?.let {
                            var parsedDataArray = ArrayList<WebToonModel>() // 데이터 전체를 리스트
                            val body = it.asJsonArray
                            body.forEach {  resultItem ->
                                val resultOBject = resultItem.asJsonObject
                                val title: String  = resultOBject.get("title").asString
                                val artist: String  = resultOBject.get("artist").asString
                                val url: String  = resultOBject.get("url").asString
                                val img: String = resultOBject.get("img").asString
                                val weeknum: String = resultOBject.get("weekday").asString
                                val webToonItem = WebToonModel(
                                        title = title,
                                        artist = artist,
                                        url = url,
                                        img = img,
                                        weekday = weeknum
                                )
                                parsedDataArray.add(webToonItem)
                            }
                            completion(RESPONSE_STATE.OKAY,parsedDataArray) // 결과를 입력한다
                        }
                    }
                }

            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG,"응답실패")
                completion(RESPONSE_STATE.FAIL,null)
            }

        })
    }
}