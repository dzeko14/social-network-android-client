package com.github.dzeko14.socialnetworkapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.databinding.ActivityLoginBinding
import com.github.dzeko14.socialnetworkapp.viewmodel.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var binding: ActivityLoginBinding

    init {
        App.appComponent.provideLoginActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this

        loginViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(LoginViewModel::class.java)

        binding.viewModel = loginViewModel
        binding.executePendingBindings()

        loginViewModel.state.observe(this, Observer {
            if (it == LoginViewModel.State.FAILED) Snackbar
                .make(binding.root,
                    getString(R.string.login_data),
                    Snackbar.LENGTH_LONG)
                .show()
        })

        loginViewModel.route.observe(this, Observer {
            it?.execute(this)
        })
    }


}
