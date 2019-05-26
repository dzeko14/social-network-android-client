package com.github.dzeko14.socialnetworkapp.di.model

import androidx.lifecycle.ViewModelProvider
import com.github.dzeko14.socialnetworkapp.viewmodel.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {

    @Provides
    fun providesViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory {
        return viewModelFactory
    }
}