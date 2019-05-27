package com.github.dzeko14.socialnetworkapp.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.view.fragment.abstracts.AbstractPostListFragment
import com.github.dzeko14.socialnetworkapp.viewmodel.PostListViewModel
import javax.inject.Inject

class PostListFragment : AbstractPostListFragment() {

    @Inject
    lateinit var vewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: PostListViewModel

    init {
        App.appComponent.providePostListFragment(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, vewModelFactory)
            .get(PostListViewModel::class.java)

        viewModel.posts.observe(this, Observer {
            it?.let { posts ->
                rvAdapter.posts = posts
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPosts()
    }



    companion object {
        fun create(): PostListFragment {
            return PostListFragment()
        }
    }
}
