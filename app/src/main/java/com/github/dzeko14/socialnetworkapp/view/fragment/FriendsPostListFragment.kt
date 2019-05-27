package com.github.dzeko14.socialnetworkapp.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.view.fragment.abstracts.AbstractPostListFragment
import com.github.dzeko14.socialnetworkapp.viewmodel.FriendsPostListViewModel
import javax.inject.Inject

class FriendsPostListFragment : AbstractPostListFragment() {
    @Inject
    lateinit var vewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FriendsPostListViewModel

    init {
        App.appComponent.provideFriendsPostListFragment(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, vewModelFactory)
            .get(FriendsPostListViewModel::class.java)

        viewModel.posts.observe(this, Observer {
            it?.let { posts ->
                rvAdapter.posts = posts
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFriendsPosts()
    }

    companion object {
        fun create(): FriendsPostListFragment{
            return FriendsPostListFragment()
        }
    }
}
