package com.github.dzeko14.socialnetworkapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.databinding.CommentListItemBinding
import com.github.dzeko14.socialnetworkapp.model.Comment

class CommentRecyclerViewAdapter : RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder>() {

    var comments: List<Comment> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CommentListItemBinding>(layoutInflater,
            R.layout.comment_list_item,
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.update(comments[position])


    class ViewHolder(private val binding: CommentListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun update(comment: Comment) {
            binding.comment = comment
            binding.executePendingBindings()
        }
    }
}