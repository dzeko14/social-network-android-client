package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.databinding.ActivityCommentsBinding
import com.github.dzeko14.socialnetworkapp.view.adapter.CommentRecyclerViewAdapter
import com.github.dzeko14.socialnetworkapp.viewmodel.CommentViewModel
import javax.inject.Inject

class CommentsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CommentViewModel

    private lateinit var binding: ActivityCommentsBinding

    private val rvAdapter = CommentRecyclerViewAdapter()

    init {
        App.appComponent.provideCommentsActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comments)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CommentViewModel::class.java)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CommentsActivity)
            adapter = rvAdapter
        }

        binding.viewModel = viewModel

        binding.executePendingBindings()

        viewModel.comments.observe(this, Observer {
            it?.let {comments ->
                rvAdapter.comments = comments
            }
        })

        viewModel.content.observe(this, Observer {
            val size = it?.length ?: 0
            binding.isContentEmpty = size == 0
            binding.executePendingBindings()
        })

        binding.isContentEmpty = true
        binding.executePendingBindings()

        viewModel.getComments(intent.getLongExtra(POST_ID_KEY, -1))
    }

    companion object {
        const val POST_ID_KEY = "Post_id_key"
    }
}
