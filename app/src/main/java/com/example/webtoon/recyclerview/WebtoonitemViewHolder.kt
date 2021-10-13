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
        initWebView(model.img.toString())
        webtoonUri = model.url.toString()
    }

    override fun onClick(v: View?) {
        when(v) {
            webtoonPhoto -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webtoonUri))
                v.context.startActivities(arrayOf(intent))
            }
        }
    }

    private fun initWebView(address : String) {
        webtoonPhoto.apply{
          settings.javaScriptEnabled = true
          webViewClient = WebViewClient()
          webChromeClient = WebChromeClient()
          loadUrl(address)
        }
        
    }

}
