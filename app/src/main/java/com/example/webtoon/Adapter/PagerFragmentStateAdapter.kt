package com.example.webtoon.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.webtoon.WebttonCollection

class PagerFragmentStateAdapter(fragmentActivity: FragmentActivity,tabSize : Int): FragmentStateAdapter(fragmentActivity) {
    private var size : Int = tabSize

    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> WebttonCollection()
            2-> WebttonCollection()
            3 -> WebttonCollection()
            4 -> WebttonCollection()
            5 -> WebttonCollection()
            6 -> WebttonCollection()
            7 -> WebttonCollection()
            else -> WebttonCollection()
        }
    }

}