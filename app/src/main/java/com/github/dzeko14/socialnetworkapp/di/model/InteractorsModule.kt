package com.github.dzeko14.socialnetworkapp.di.model

import com.github.dzeko14.socialnetworkapp.interactor.*
import com.github.dzeko14.socialnetworkapp.interactor.implementation.MockCommentInteractor
import com.github.dzeko14.socialnetworkapp.interactor.implementation.MockPostInteractors
import com.github.dzeko14.socialnetworkapp.interactor.implementation.MockUserInteractors
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.model.User
import dagger.Module
import dagger.Provides

@Module
class InteractorsModule {
    @Provides
    fun providesLoginUserInteractor(mockUserInteractors: MockUserInteractors): LoginUserInteractor {
        return mockUserInteractors
    }

    @Provides
    fun providesRegisterUserInteractor(mockUserInteractors: MockUserInteractors): RegisterUserInteractor {
        return mockUserInteractors
    }

    @Provides
    fun providesGetFriendsListInteractor(mockUserInteractors: MockUserInteractors): GetFriendsListInteractor {
        return mockUserInteractors
    }

    @Provides
    fun providesGetPostListInteractor(mockPostInteractors: MockPostInteractors): GetListInteractor<Post> {
        return mockPostInteractors
    }

    @Provides
    fun providesGetFriendsPostListInteractor(mockPostInteractors: MockPostInteractors): GetFriendsPostListInteractor {
        return mockPostInteractors
    }

    @Provides
    fun providesGetUserByIdInteractor(mockUserInteractors: MockUserInteractors): GetByIdInteractor<User, Long> {
        return mockUserInteractors
    }

    @Provides
    fun providesGetCurrentUserInfoInteractor(mockUserInteractors: MockUserInteractors): GetCurrentUserInfoInteractor {
        return mockUserInteractors
    }

    @Provides
    fun providesGetPostByIdInteractor(mockPostInteractors: MockPostInteractors): GetByIdInteractor<Post, Long> {
        return mockPostInteractors
    }

    @Provides
    fun providesCreateCommentInteractor(mockCommentInteractor: MockCommentInteractor): CreateCommentInteractor {
        return mockCommentInteractor
    }

    @Provides
    fun providesGetCommentsByPostInteractor(mockCommentInteractor: MockCommentInteractor): GetCommentsByPostInteractor {
        return mockCommentInteractor
    }
}