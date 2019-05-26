package com.github.dzeko14.socialnetworkapp.route

import android.app.Activity
import android.content.Intent
import com.github.dzeko14.socialnetworkapp.view.activity.RegisterActivity

class RegisterActivityRoute : ActivityRoute {
    override fun execute(activity: Activity) {
        activity.startActivity(
            Intent(activity, RegisterActivity::class.java)
        )
    }
}