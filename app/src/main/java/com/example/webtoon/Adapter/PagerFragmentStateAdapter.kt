package com.example.webtoon.Adapter

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.WebToonCollection
import com.example.webtoon.retorfit.RetrofitManager
import com.example.webtoon.utils.Constants
import com.example.webtoon.utils.RESPONSE_STATE

class PagerFragmentStateAdapter(fragmentActivity: FragmentActivity,tabSize : Int): FragmentStateAdapter(fragmentActivity) {
    private var size : Int = tabSize

    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> WebToonCollection("0")
            2 -> WebToonCollection("1")
            3 -> WebToonCollection("2")
            4 -> WebToonCollection("3")
            5 -> WebToonCollection("4")
            6 -> WebToonCollection("5")
            7 -> WebToonCollection("6")
            else -> WebToonCollection("7")
        }
    }
}