package com.example.dailynewsapp.network


data class NewsResult(
    val status: String?,
    val totalResults: Int,
    val articles: List<Article>
)