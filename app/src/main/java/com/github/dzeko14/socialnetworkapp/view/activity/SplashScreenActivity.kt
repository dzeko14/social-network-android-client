package com.github.dzeko14.socialnetworkapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.viewmodel.SplashScreenViewModel
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashScreenViewModel

    init {
        App.appComponent.provideSplashScreenActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(SplashScreenViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            it.execute(this@SplashScreenActivity)
            finish()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.resolveRoute()
    }
}
