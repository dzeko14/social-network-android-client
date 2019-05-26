package com.github.dzeko14.socialnetworkapp.di.model

import com.github.dzeko14.socialnetworkapp.api.UserService
import com.github.dzeko14.socialnetworkapp.interactor.LoginUserInteractor
import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.viewmodel.factory.LoginViewModelFactory
import com.github.dzeko14.socialnetworkapp.viewmodel.factory.SplashScreenViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {
    @Provides
    fun providesSplashScreenVMFactory(tokenStorage: TokenStorage): SplashScreenViewModelFactory {
        return SplashScreenViewModelFactory(tokenStorage)
    }

    @Provides
    fun providesLoginVMFactory(loginUserInteractor: LoginUserInteractor): LoginViewModelFactory {
        return LoginViewModelFactory(loginUserInteractor)
    }
}