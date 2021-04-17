package com.example.webtoon.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.webtoon.Model.WebToonModel

//데이터 변경 관련

class WebViewModel : ViewModel() {
    //뮤터블 라이브 데이터 -  수정가능
    //라이브 데이터 - 값 변경 불가
    private val _updateList = MutableLiveData<ArrayList<WebToonModel>>()
    // 변경되지 않는 데이터를  가져 올때 이름을 _언더스코어 없이 설정
    val updateList: LiveData<ArrayList<WebToonModel>>
    get() = _updateList

    fun update(arrayList: ArrayList<WebToonModel>) {
         _updateList.value =  arrayList
    }
}