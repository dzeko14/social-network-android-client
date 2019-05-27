package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.databinding.ActivityUserDetailBinding
import com.github.dzeko14.socialnetworkapp.viewmodel.UserDetailViewModel
import javax.inject.Inject

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserDetailViewModel

    init {
        App.appComponent.provideUserDetailActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(UserDetailViewModel::class.java)

        val userId = intent.getLongExtra(USER_ID_KEY, -1)
        viewModel.getUserInfo(userId)

        viewModel.user.observe(this, Observer {
            it?.let {
                binding.user = it
                binding.executePendingBindings()
            }
        })
    }

    companion object {
        const val USER_ID_KEY = "user_id_key"
    }
}
