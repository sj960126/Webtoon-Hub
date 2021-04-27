package com.example.webtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import com.example.webtoon.Adapter.PagerFragmentStateAdapter
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.ViewModel.WebViewModel
import com.example.webtoon.databinding.ActivityMainBinding
import com.example.webtoon.retorfit.RetrofitManager
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
        init()
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

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }
    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}