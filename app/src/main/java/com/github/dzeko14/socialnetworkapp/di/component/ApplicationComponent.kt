package com.github.dzeko14.socialnetworkapp.di.component

import android.content.Context
import com.github.dzeko14.socialnetworkapp.di.model.InteractorsModule
import com.github.dzeko14.socialnetworkapp.di.model.SharedPreferencesModule
import com.github.dzeko14.socialnetworkapp.di.model.TokenStorageModule
import com.github.dzeko14.socialnetworkapp.di.model.ViewModelFactoryModule
import com.github.dzeko14.socialnetworkapp.view.activity.*
import com.github.dzeko14.socialnetworkapp.view.fragment.FriendsListFragment
import com.github.dzeko14.socialnetworkapp.view.fragment.FriendsPostListFragment
import com.github.dzeko14.socialnetworkapp.view.fragment.PostListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        TokenStorageModule::class,
        ViewModelFactoryModule::class,
        SharedPreferencesModule::class,
        InteractorsModule::class
    ]
)
@Singleton
interface ApplicationComponent {
    fun provideSplashScreenActivity(activity: SplashScreenActivity)
    fun provideLoginActivity(activity: LoginActivity)
    fun provideRegisterActivity(activity: RegisterActivity)
    fun provideMainActivity(mainActivity: MainActivity)
    fun provideFriendListFragment(friendsListFragment: FriendsListFragment)
    fun providePostListFragment(postListFragment: PostListFragment)
    fun provideFriendsPostListFragment(friendsPostListFragment: FriendsPostListFragment)
    fun provideUserDetailActivity(userDetailActivity: UserDetailActivity)
    fun providePostDetailActivity(postDetailActivity: PostDetailActivity)
    fun provideCommentsActivity(commentsActivity: CommentsActivity)
    fun provideAllUsersActivity(allUsersActivity: AllUsersActivity)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun bindApplicationContext(context: Context): Builder
    }
}