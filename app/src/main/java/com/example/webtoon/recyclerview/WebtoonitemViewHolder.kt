package com.example.webtoon.recyclerview

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.webtoon.App
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.R
import com.example.webtoon.WebToonCollection
import com.example.webtoon.databinding.WebtoonItemBinding
import com.squareup.picasso.Picasso

class WebtoonitemViewHolder(val binding : WebtoonItemBinding):
                                         RecyclerView.ViewHolder(binding.root),
                                         View.OnClickListener {
    private var webtoonUri: String  = ""
    private val webtoonPhoto = binding.ivImg
    private val webtoonTitle = binding.tvTitle
    private val webtoonArticle = binding.tvArticle

    init {
        webtoonPhoto.setOnClickListener(this)
    }

    fun bindWithView(model: WebToonModel) {
        webtoonTitle.text = model.title
        webtoonArticle.text = model.artist
        Log.d("이미지확인",model.img.toString())
        Picasso.get().load(model.img).fit().into(webtoonPhoto)

//        Glide.with(App.instance ).load(model.img).placeholder(R.drawable.ic_webloding).into(webtoonPhoto)
        webtoonUri = model.url.toString()
    }

    override fun onClick(v: View?) {
        when(v) {
            webtoonPhoto -> {
                Log.d("로그","이미지 클릭")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webtoonUri))
                v.context.startActivities(arrayOf(intent))
            }
        }
    }
}