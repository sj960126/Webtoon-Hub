package com.example.webtoon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.ViewModel.WebViewModel
import com.example.webtoon.databinding.FragmentWebttonBinding

class WebToonCollection: Fragment() {
    private var arrayList: ArrayList<WebToonModel>? = null
    private lateinit var binding: FragmentWebttonBinding
    private val model: WebViewModel by activityViewModels<WebViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            arrayList = it.getSerializable("arrayList") as ArrayList<WebToonModel>?
        }
        Log.d("api확인", "프레그먼트 확인${arrayList?.size.toString()}")
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