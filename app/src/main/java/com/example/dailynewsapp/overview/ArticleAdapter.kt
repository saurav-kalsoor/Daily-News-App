package com.example.dailynewsapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsapp.databinding.ItemArticleBinding
import com.example.dailynewsapp.network.Article

class ArticleAdapter(val listener: OnItemClickListener) : ListAdapter<Article, ArticleAdapter.ArticleViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
        holder.itemView.setOnClickListener {
            listener.onItemClick(article.url)
        }
    }

    class ArticleViewHolder(private val binding : ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article : Article){
            binding.article = article
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }
    }
}

interface OnItemClickListener{
    fun onItemClick(url : String?)
}
