package com.example.webtoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.webtoon.Adapter.PagerFragmentStateAdapter
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.databinding.ActivityMainBinding
import com.example.webtoon.retorfit.RetrofitManager
import com.example.webtoon.utils.RESPONSE_STATE
import com.google.android.material.tabs.TabLayoutMediator
import com.example.webtoon.utils.Constants.TAG
class MainActivity :AppCompatActivity(){
    private val tabTextList = arrayListOf("일","월","화","수","목","금","토","완")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.pager.adapter = PagerFragmentStateAdapter(this, tabTextList.size)
        TabLayoutMediator(binding.tabLayout, binding.pager) {
            tab , position ->
            tab.text = tabTextList[position]
        }.attach()
        apicall()
    }
    fun setDataSet(fragment: Fragment, arrayList: ArrayList<WebToonModel>?){
        val bundle = Bundle()
        bundle.putSerializable("arrayList",arrayList)

        fragment.arguments = bundle
    }
    fun apicall() {
        // naver or daum
        //to do naver 부분 토글 스위치
        RetrofitManager.instance.searchWebtoon(searchTerm = "0", completion = {
            responseState, responsArrayList ->
            when(responseState){
                RESPONSE_STATE.OKAY -> {
                    Log.d(TAG,"호출 성공 ${responsArrayList?.size}")
                    setDataSet(WebToonCollection(), responsArrayList) //프레그먼트 값 전달
                }
                RESPONSE_STATE.FAIL -> {
                    Toast.makeText(this,"서버 에러",Toast.LENGTH_SHORT).show()
                }

            }
        })
    }
}