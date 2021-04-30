package com.example.webtoon.recyclerview

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.databinding.WebtoonItemBinding
import com.squareup.picasso.Picasso

class WebtoonitemViewHolder(val binding: WebtoonItemBinding):
                                         RecyclerView.ViewHolder(binding.root),
                                         View.OnClickListener {
    private var webtoonUri: String  = ""
    private val webtoonPhoto = binding.wbImg
    private val webtoonTitle = binding.tvTitle
    private val webtoonArticle = binding.tvArticle

    init {
        webtoonPhoto.setOnClickListener(this)
    }

    fun bindWithView(model: WebToonModel) {
        webtoonTitle.text = model.title
        webtoonArticle.text = model.artist
        Log.d("이미지확인", model.img.toString())
        initWebView(model.img.toString())
//        Glide.with(App.instance ).load(model.img).placeholder(R.drawable.ic_webloding).into(webtoonPhoto)
        webtoonUri = model.url.toString()
    }

    override fun onClick(v: View?) {
        when(v) {
            webtoonPhoto -> {
                Log.d("로그", "이미지 클릭")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webtoonUri))
                v.context.startActivities(arrayOf(intent))
            }
        }
    }

    private fun initWebView(address : String) {

        // 와이파이 & 데이터 연결되어 있으면 웹뷰 생성

            // 인터넷 연결 되어 있을 때 (셀룰러/와이파이)
        webtoonPhoto.settings.javaScriptEnabled = true // 자바 스크립트 허용

            // 웹뷰안에 새 창이 뜨지 않도록 방지
        webtoonPhoto.webViewClient = WebViewClient()
        webtoonPhoto.webChromeClient = WebChromeClient()

            // 원하는 주소를 WebView에 연결
        webtoonPhoto.loadUrl(address)


    }

}