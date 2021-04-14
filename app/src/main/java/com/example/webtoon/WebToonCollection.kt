package com.example.webtoon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.databinding.FragmentWebttonBinding

class WebToonCollection: Fragment() {
    private var arrayList: ArrayList<WebToonModel>? = null
    private lateinit var binding: FragmentWebttonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            arrayList = it.getSerializable("arrayList") as ArrayList<WebToonModel>?
        }
        Log.d("api확", "프레그먼트 확${arrayList?.get(0)?.artist.toString()}")
    }
    // binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebttonBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}