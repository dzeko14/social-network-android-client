package com.github.dzeko14.socialnetworkapp.route

import android.content.Context
import android.content.Intent
import com.github.dzeko14.socialnetworkapp.view.activity.LoginActivity

class LoginActivityRoute : ActivityRoute {
    override fun execute(activityContext: Context) {
        activityContext.startActivity(
            Intent(activityContext, LoginActivity::class.java)
        )
    }
}