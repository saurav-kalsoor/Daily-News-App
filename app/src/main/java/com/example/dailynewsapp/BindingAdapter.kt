package com.example.dailynewsapp

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dailynewsapp.network.Article
import com.example.dailynewsapp.overview.ArticleAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView : ImageView, imgUrl : String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerview(recyclerView: RecyclerView, data : List<Article>?){
    val adapter = recyclerView.adapter as ArticleAdapter
    adapter.submitList(data)
}