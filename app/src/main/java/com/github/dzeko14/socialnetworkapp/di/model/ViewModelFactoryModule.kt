package com.github.dzeko14.socialnetworkapp.di.model

import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.viewmodel.factory.SplashScreenViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {
    @Provides
    fun providesSplashScreenVMFactory(tokenStorage: TokenStorage): SplashScreenViewModelFactory {
        return SplashScreenViewModelFactory(tokenStorage)
    }
}