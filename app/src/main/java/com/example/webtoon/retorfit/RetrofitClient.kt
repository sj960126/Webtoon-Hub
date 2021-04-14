package com.example.webtoon.retorfit

import android.util.Log
import com.example.webtoon.utils.API
import com.example.webtoon.utils.Constants.TAG
import com.example.webtoon.utils.isJsonArray
import com.example.webtoon.utils.isJsonObJect
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

object RetrofitClient {
    //클라이언트 선언
    private var retrofitClient: Retrofit? = null

    //레트로핏 클라잉언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG,"getClientCall")

        val client = OkHttpClient.Builder()
        //로그를 찍기 위해 로깅 인터셉터 추가
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(TAG,message)
                when {
                    message.isJsonObJect() ->
                        Log.d(TAG, JSONObject(message).toString(4))
                    message.isJsonArray() ->
                        Log.d(TAG, JSONArray(message).toString(4))
                    else -> {
                        try{
                            Log.d(TAG, JSONObject(message).toString(4))
                        }catch (e: Exception) {
                        }
                    }
                }
            }
        })

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        //위에서 설정한 로깅 인터셉터를 클라이언트에 추
        client.addInterceptor(loggingInterceptor)


        //타임아웃 추가
        client.connectTimeout(10,TimeUnit.SECONDS)
        client.readTimeout(10,TimeUnit.SECONDS)
        client.writeTimeout(10,TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)


        //기본 파라미터 추가
        val baseParameterInterceptor: Interceptor = (object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                Log.d(TAG,"인터셉터 호출")
                //오리지날 리퀘스트
                val originalRequest = chain.request() // 베이스 추가 전

                val addeUrl = originalRequest.url.newBuilder().addQueryParameter("service",API.WebToon_naver).build()
                val finalRequest = originalRequest.newBuilder().url(addeUrl).method(originalRequest.method,originalRequest.body).build()
                return chain.proceed(finalRequest)
            }
        })

        client.addInterceptor(baseParameterInterceptor)

        if (retrofitClient == null) { //레트로핏 클라이언트가 없으면 객체 생성
            //레트로핏 빌더를 통해 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    //위에서 설정한 클라이언트로 레트로핏 클라이언트를 설정한다.
                    .client(client.build())
                    .build()
        }
        return retrofitClient
    }

}