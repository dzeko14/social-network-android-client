package com.github.dzeko14.socialnetworkapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.databinding.PostListItemBinding
import com.github.dzeko14.socialnetworkapp.model.Post

class PostListRecyclerViewAdapter : RecyclerView.Adapter<PostListRecyclerViewAdapter.ViewHolder>() {

    var posts: List<Post> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<PostListItemBinding>(layoutInflater,
            R.layout.post_list_item,
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.update(posts[position])

    class ViewHolder(private val binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun update(p: Post) {
            binding.post = p
            val date = "1-1-2019" //TODO: Implement date formatting
            binding.postDate = date
            binding.executePendingBindings()
        }
    }
}