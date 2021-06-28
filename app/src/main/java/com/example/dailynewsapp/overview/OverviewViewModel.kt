package com.example.dailynewsapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailynewsapp.network.Article
import com.example.dailynewsapp.network.NewsApi
import com.example.dailynewsapp.network.NewsResult
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel : ViewModel() {

    private val apiKey = "492ffb82d4e04cfab707e559c78d9d1a"


    private val _articleList = MutableLiveData<List<Article>>()
    val articleList : LiveData<List<Article>>
    get() = _articleList



    init {
        getNewsData()
    }

    private fun getNewsData(){
        viewModelScope.launch {
            try {
                _articleList.value = NewsApi.retrofitService.getNews(apiKey, "us").articles
            }catch (e : Exception){

            }
        }
    }
}