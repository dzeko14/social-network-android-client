package com.github.dzeko14.socialnetworkapp.di.component

import android.content.Context
import com.github.dzeko14.socialnetworkapp.di.model.InteractorsModule
import com.github.dzeko14.socialnetworkapp.di.model.SharedPreferencesModule
import com.github.dzeko14.socialnetworkapp.di.model.TokenStorageModule
import com.github.dzeko14.socialnetworkapp.di.model.ViewModelFactoryModule
import com.github.dzeko14.socialnetworkapp.view.activity.LoginActivity
import com.github.dzeko14.socialnetworkapp.view.activity.SplashScreenActivity
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

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun bindApplicationContext(context: Context): Builder
    }
}