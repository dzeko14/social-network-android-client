package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.MainActivity

class MainActivityRoute : ActivityRoute {
    override fun execute(activity: FragmentActivity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}