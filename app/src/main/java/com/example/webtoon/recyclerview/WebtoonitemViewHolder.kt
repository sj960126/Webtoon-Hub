package com.example.webtoon.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
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

    private val WebtoonPhoto = binding.ivImg
    private val WebtoonTitle = binding.tvTitle
    private val WebtoonArticle = binding.tvArticle

    init {
        WebtoonPhoto.setOnClickListener(this)
    }

    fun bindWithView(model: WebToonModel) {
        WebtoonTitle.text = model.title
        WebtoonArticle.text = model.artist
        Log.d("이미지확인",model.img.toString())
        Picasso.get().load(model.img).into(WebtoonPhoto)
    }

    override fun onClick(v: View?) {
        when(v) {
            WebtoonPhoto -> {
                Log.d("로그","이미지 클릭")
            }
        }
    }
}