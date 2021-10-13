package com.example.webtoon.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.webtoon.Model.WebToonModel

//데이터 변경 관련

class WebViewModel : ViewModel() {
 
    val data: MutableLiveData<ArrayList<WebToonModel>> by lazy {
        MutableLiveData<ArrayList<WebToonModel>>()
    }

    fun getData(): LiveData<ArrayList<WebToonModel>> {
        return data
    }
}
