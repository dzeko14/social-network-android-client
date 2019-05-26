package com.github.dzeko14.socialnetworkapp.route

import android.app.Activity
import android.content.Intent
import com.github.dzeko14.socialnetworkapp.view.activity.MainActivity

class MainActivityRoute : ActivityRoute {
    override fun execute(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}