package com.example.webtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webtoon.Adapter.PagerFragmentStateAdapter
import com.example.webtoon.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val tabTextList = arrayListOf("일","월","화","수","목","금","토","완")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private  fun init() {
        binding.pager.adapter = PagerFragmentStateAdapter(this, tabTextList.size)
        TabLayoutMediator(binding.tabLayout, binding.pager) {
            tab , position ->
            tab.text = tabTextList[position]
        }.attach()
    }
}