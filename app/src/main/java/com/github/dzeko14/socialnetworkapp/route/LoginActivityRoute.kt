package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.LoginActivity

class LoginActivityRoute : ActivityRoute {
    override fun execute(activity: FragmentActivity) {
        activity.startActivity(
            Intent(activity, LoginActivity::class.java)
        )
    }
}