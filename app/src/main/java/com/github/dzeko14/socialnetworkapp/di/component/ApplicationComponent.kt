package com.github.dzeko14.socialnetworkapp.di.component

import android.content.Context
import com.github.dzeko14.socialnetworkapp.di.model.SharedPreferencesModule
import com.github.dzeko14.socialnetworkapp.di.model.TokenStorageModule
import com.github.dzeko14.socialnetworkapp.di.model.ViewModelFactoryModule
import com.github.dzeko14.socialnetworkapp.view.activity.SplashScreenActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        TokenStorageModule::class,
        ViewModelFactoryModule::class,
        SharedPreferencesModule::class
    ]
)
@Singleton
interface ApplicationComponent {
    fun provideSplashScreenActivity(activity: SplashScreenActivity)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun bindApplicationContext(context: Context): Builder
    }
}