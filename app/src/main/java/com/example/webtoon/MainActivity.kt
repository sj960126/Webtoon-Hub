package com.example.webtoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import com.example.webtoon.Adapter.PagerFragmentStateAdapter
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.ViewModel.WebViewModel
import com.example.webtoon.databinding.ActivityMainBinding
import com.example.webtoon.retorfit.RetrofitManager
import com.example.webtoon.utils.Constants
import com.example.webtoon.utils.RESPONSE_STATE
import com.google.android.material.tabs.TabLayoutMediator
import com.example.webtoon.utils.Constants.TAG
import com.google.android.material.tabs.TabLayout

class MainActivity :AppCompatActivity(), TabLayout.OnTabSelectedListener{
    private val tabTextList = arrayListOf("일","월","화","수","목","금","토","완")
    private lateinit var binding: ActivityMainBinding
    private var webToonList: ArrayList<WebToonModel>? = null
    val model : WebViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apicall("0")
        Handler().postDelayed({
            binding.lottieLoding.visibility = View.INVISIBLE
            init()
        },2000)
    }
    override fun onResume() {
        super.onResume()
    }

    private fun init() {
        binding.pager.adapter = PagerFragmentStateAdapter(this, tabTextList.size)
        TabLayoutMediator(binding.tabLayout, binding.pager) {
            tab , position ->
            tab.text = tabTextList[position]
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(this)
    }


    fun apicall(postion: String) {
        // naver or daum
        //to do naver 부분 토글 스위치
        RetrofitManager.instance.searchWebtoon(searchTerm = postion, completion = {
            responseState, responsArrayList ->
            when(responseState){
                RESPONSE_STATE.OKAY -> {
                    Log.d(Constants.TAG,"호출 성공 ${responsArrayList?.size}")
                    if (responsArrayList != null) {
                        model.data.value = responsArrayList
                    }
                }
                RESPONSE_STATE.FAIL -> {
                }
            }
        })
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        apicall(tab?.position.toString())
    }
    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}