package com.github.dzeko14.socialnetworkapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.dzeko14.socialnetworkapp.api.UserService
import com.github.dzeko14.socialnetworkapp.interactor.*
import com.github.dzeko14.socialnetworkapp.model.Comment
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.viewmodel.*
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
    private val registerUserInteractor: RegisterUserInteractor,
    private val getFriendsListInteractor: GetFriendsListInteractor,
    private val getPostListInteractor: GetListInteractor<Post>,
    private val getFriendsPostListInteractor: GetFriendsPostListInteractor,
    private val getUserByIdInteractor: GetByIdInteractor<User, Long>,
    private val getCurrentUserInfoInteractor: GetCurrentUserInfoInteractor,
    private val getPostByIdInteractor: GetByIdInteractor<Post, Long>,
    private val createCommentInteractor: CreateCommentInteractor,
    private val getCommentsByPostInteractor: GetCommentsByPostInteractor
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

            (modelClass.isAssignableFrom(MainViewModel::class.java))
            -> MainViewModel() as T

            (modelClass.isAssignableFrom(FriendListViewModel::class.java))
            -> FriendListViewModel(getFriendsListInteractor) as T

            (modelClass.isAssignableFrom(PostListViewModel::class.java))
            -> PostListViewModel(getPostListInteractor) as T

            (modelClass.isAssignableFrom(FriendsPostListViewModel::class.java))
            -> FriendsPostListViewModel(getFriendsPostListInteractor) as T

            (modelClass.isAssignableFrom(UserDetailViewModel::class.java))
            -> UserDetailViewModel(getUserByIdInteractor, getCurrentUserInfoInteractor) as T

            (modelClass.isAssignableFrom(PostDetailViewModel::class.java))
            -> PostDetailViewModel(getPostByIdInteractor) as T

            (modelClass.isAssignableFrom(CommentViewModel::class.java))
            -> CommentViewModel(getCommentsByPostInteractor, createCommentInteractor) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
}
