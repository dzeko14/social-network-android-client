package com.github.dzeko14.socialnetworkapp.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.databinding.FriendsListItemBinding
import com.github.dzeko14.socialnetworkapp.model.User

class FriendsListRecyclerViewAdapter : RecyclerView.Adapter<FriendsListRecyclerViewAdapter.ViewHolder>() {
    private var friends: List<User> = emptyList()

    init {
        Log.d("Adapter", "FriendsListRecyclerViewAdapter created")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FriendsListItemBinding>(layoutInflater,
            R.layout.friends_list_item,
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = friends.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.update(friends[position])
    }

    fun updateFriendList(friends: List<User>) {
        this.friends = friends
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: FriendsListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun update(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }
}