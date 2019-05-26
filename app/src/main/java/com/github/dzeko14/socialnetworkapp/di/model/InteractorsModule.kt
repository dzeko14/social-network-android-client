package com.github.dzeko14.socialnetworkapp.di.model

import com.github.dzeko14.socialnetworkapp.interactor.LoginUserInteractor
import com.github.dzeko14.socialnetworkapp.interactor.implementation.MockUserInteractors
import dagger.Module
import dagger.Provides

@Module
class InteractorsModule {
    @Provides
    fun providesLoginUserInteractor(mockUserInteractors: MockUserInteractors): LoginUserInteractor {
        return mockUserInteractors
    }
}