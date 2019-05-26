package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.databinding.ActivityRegisterBinding
import com.github.dzeko14.socialnetworkapp.route.RegisterActivityRoute
import com.github.dzeko14.socialnetworkapp.viewmodel.RegisterViewModel
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RegisterViewModel

    private lateinit var binding: ActivityRegisterBinding

    init {
        App.appComponent.provideRegisterActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(RegisterViewModel::class.java)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        viewModel.state.observe(this, Observer {
            when(it) {
                RegisterViewModel.State.COMPLETE -> finish()
                RegisterViewModel.State.ERROR -> TODO()
            }
        })
    }
}
