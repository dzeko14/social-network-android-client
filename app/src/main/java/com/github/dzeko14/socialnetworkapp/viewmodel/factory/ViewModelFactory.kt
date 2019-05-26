package com.github.dzeko14.socialnetworkapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.dzeko14.socialnetworkapp.api.UserService
import com.github.dzeko14.socialnetworkapp.interactor.LoginUserInteractor
import com.github.dzeko14.socialnetworkapp.interactor.RegisterUserInteractor
import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.viewmodel.LoginViewModel
import com.github.dzeko14.socialnetworkapp.viewmodel.RegisterViewModel
import com.github.dzeko14.socialnetworkapp.viewmodel.SplashScreenViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
@Singleton
class ViewModelFactory @Inject constructor(
    private val loginUserInteractor: LoginUserInteractor,
    private val tokenStorage: TokenStorage,
    private val registerUserInteractor: RegisterUserInteractor
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            (modelClass.isAssignableFrom(LoginViewModel::class.java))
                -> LoginViewModel(loginUserInteractor) as T

            (modelClass.isAssignableFrom(SplashScreenViewModel::class.java))
                -> SplashScreenViewModel(tokenStorage) as T

            (modelClass.isAssignableFrom(RegisterViewModel::class.java))
            -> RegisterViewModel(registerUserInteractor) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
}
