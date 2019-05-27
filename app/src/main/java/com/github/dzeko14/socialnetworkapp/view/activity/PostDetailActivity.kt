package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.databinding.ActivityPostDetailBinding
import com.github.dzeko14.socialnetworkapp.viewmodel.PostDetailViewModel
import com.github.dzeko14.socialnetworkapp.viewmodel.factory.ViewModelFactory
import javax.inject.Inject

class PostDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostDetailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: PostDetailViewModel

    init {
        App.appComponent.providePostDetailActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(PostDetailViewModel::class.java)

        val postId = intent.getLongExtra(POST_ID_KEY, -1)
        viewModel.getPost(postId)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        viewModel.post.observe(this, Observer {
            it?.let {post ->
                binding.post = post
                binding.postDate = "1-1-2019" //TODO: Implement date formatting
                binding.executePendingBindings()
            }
        })
    }

    companion object {
        const val POST_ID_KEY = "post_id_key"
    }
}
