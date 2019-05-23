package com.github.dzeko14.socialnetworkapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.viewmodel.SplashScreenViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class SplashScreenViewModelFactory @Inject constructor(
    private val tokenStorage: TokenStorage
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashScreenViewModel(tokenStorage) as T
    }
}