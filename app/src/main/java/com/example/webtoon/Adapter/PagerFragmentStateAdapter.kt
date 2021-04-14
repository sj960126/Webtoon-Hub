package com.example.webtoon.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.webtoon.WebToonCollection

class PagerFragmentStateAdapter(fragmentActivity: FragmentActivity,tabSize : Int): FragmentStateAdapter(fragmentActivity) {
    private var size : Int = tabSize

    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> WebToonCollection()
            2-> WebToonCollection()
            3 -> WebToonCollection()
            4 -> WebToonCollection()
            5 -> WebToonCollection()
            6 -> WebToonCollection()
            7 -> WebToonCollection()
            else -> WebToonCollection()
        }
    }

}