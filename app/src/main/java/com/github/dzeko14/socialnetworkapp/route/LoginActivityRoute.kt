package com.github.dzeko14.socialnetworkapp.route

import android.app.Activity
import android.content.Intent
import com.github.dzeko14.socialnetworkapp.view.activity.LoginActivity

class LoginActivityRoute : ActivityRoute {
    override fun execute(activity: Activity) {
        activity.startActivity(
            Intent(activity, LoginActivity::class.java)
        )
    }
}