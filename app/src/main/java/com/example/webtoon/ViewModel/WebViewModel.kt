package com.example.webtoon.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.webtoon.Model.WebToonModel

//데이터 변경 관련

class WebViewModel : ViewModel() {
    //뮤터블 라이브 데이터 -  수정가능
    //라이브 데이터 - 값 변경 불가
    val data: MutableLiveData<ArrayList<WebToonModel>> by lazy {
        MutableLiveData<ArrayList<WebToonModel>>()
    }

    fun getData(): LiveData<ArrayList<WebToonModel>> {
        return data
    }
}
