package com.github.dzeko14.socialnetworkapp.route

import android.content.Context
import android.content.Intent
import com.github.dzeko14.socialnetworkapp.view.activity.MainActivity

class MainActivityRoute : ActivityRoute {
    override fun execute(activityContext: Context) {
        val intent = Intent(activityContext, MainActivity::class.java)
        activityContext.startActivity(intent)
    }
}