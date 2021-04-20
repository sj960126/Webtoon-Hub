package com.example.webtoon.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.databinding.WebtoonItemBinding

class WebToonRecyclerViewAdapter(): RecyclerView.Adapter<WebtoonitemViewHolder>() {
    private  var webtoonList = ArrayList<WebToonModel>()
    //뷰홀더 레이아웃 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonitemViewHolder {
        val binding = WebtoonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WebtoonitemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WebtoonitemViewHolder, position: Int) {
        holder.bindWithView(this.webtoonList[position])
    }

    override fun getItemCount(): Int {
        return webtoonList.size
    }
    fun setList(webttonlist: ArrayList<WebToonModel>){
        this.webtoonList = webttonlist
    }
}