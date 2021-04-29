package com.example.webtoon

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.ViewModel.WebViewModel
import com.example.webtoon.databinding.FragmentWebttonBinding
import com.example.webtoon.recyclerview.WebToonRecyclerViewAdapter
import com.example.webtoon.retorfit.RetrofitManager
import com.example.webtoon.utils.Constants
import com.example.webtoon.utils.RESPONSE_STATE

class WebToonCollection(): Fragment() {

    private var webToonList: ArrayList<WebToonModel>? = null
    private lateinit var binding: FragmentWebttonBinding
    private lateinit var webToonRecyclerViewAdapter: WebToonRecyclerViewAdapter
    private val model: WebViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebttonBinding.inflate(inflater, container,false)
        return binding.root
//        recyclerInit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.webToonRecyclerViewAdapter = WebToonRecyclerViewAdapter()
        model.getData().value?.let { webToonRecyclerViewAdapter.setList(it) }
        binding.rcList.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        binding.rcList.adapter = this.webToonRecyclerViewAdapter
    }

    override fun onResume() {
        super.onResume()

//        Log.d("로그","프레그먼트 확인 ${model.getData().value?.size.toString()}")
    }

}