package com.github.dzeko14.socialnetworkapp.view.fragment.abstracts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.route.PostDetailRoute
import com.github.dzeko14.socialnetworkapp.view.adapter.PostListRecyclerViewAdapter

abstract class AbstractPostListFragment : AbstractListFragment() {
    override val rvAdapter = PostListRecyclerViewAdapter(::selectPostCallback)

    private fun selectPostCallback(post: Post) {
        activity?.let { activity ->
            PostDetailRoute(post.id).execute(activity)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }
}