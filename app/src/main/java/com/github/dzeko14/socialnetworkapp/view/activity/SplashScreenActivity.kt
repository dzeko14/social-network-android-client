package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.viewmodel.SplashScreenViewModel
import com.github.dzeko14.socialnetworkapp.viewmodel.factory.SplashScreenViewModelFactory
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {
    //TODO: Inject
    @Inject lateinit var viewModelFactory: SplashScreenViewModelFactory

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(SplashScreenViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            it.execute(this@SplashScreenActivity)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.resolveRoute()
    }
}
