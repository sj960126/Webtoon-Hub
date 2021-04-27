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

class WebToonCollection(callNo: String): Fragment() {

    private var webToonList: ArrayList<WebToonModel>? = null
    private lateinit var binding: FragmentWebttonBinding
    private lateinit var webToonRecyclerViewAdapter: WebToonRecyclerViewAdapter
    private val no: String = callNo

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

        apicall(no)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
//        Log.d("로그","프레그먼트 확인 ${model.getData().value?.size.toString()}")
    }

    fun recyclerInit(){
        this.webToonRecyclerViewAdapter = WebToonRecyclerViewAdapter()
        webToonList?.let { webToonRecyclerViewAdapter.setList(it) }
        binding.rcList.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        binding.rcList.adapter = this.webToonRecyclerViewAdapter
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
                        webToonList = responsArrayList
                        this.webToonRecyclerViewAdapter = WebToonRecyclerViewAdapter()
                        webToonRecyclerViewAdapter.setList(responsArrayList)
                        binding.rcList.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
                        binding.rcList.adapter = this.webToonRecyclerViewAdapter
                    }
                }
                RESPONSE_STATE.FAIL -> {
                }
            }
        })
    }
}