package com.github.dzeko14.socialnetworkapp.di.model

import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.storage.implementation.TokenStorageImpl
import dagger.Module
import dagger.Provides

@Module
class TokenStorageModule {
    @Provides
    fun providesTokenStorage(tokenStorage: TokenStorageImpl): TokenStorage {
        return tokenStorage
    }
}