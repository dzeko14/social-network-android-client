package com.github.dzeko14.socialnetworkapp.application

import android.app.Application
import com.github.dzeko14.socialnetworkapp.di.component.ApplicationComponent
import com.github.dzeko14.socialnetworkapp.di.component.DaggerApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .bindApplicationContext(this.applicationContext)
            .build()
    }

    companion object {
        lateinit var appComponent: ApplicationComponent
    }
}