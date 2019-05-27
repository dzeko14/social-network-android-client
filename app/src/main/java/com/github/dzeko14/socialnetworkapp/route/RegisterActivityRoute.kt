package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.RegisterActivity

class RegisterActivityRoute : ActivityRoute {
    override fun execute(activity: FragmentActivity) {
        activity.startActivity(
            Intent(activity, RegisterActivity::class.java)
        )
    }
}