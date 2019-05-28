package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.AllUsersActivity

class AllUsersActivityRoute : ActivityRoute {
    override fun execute(activity: FragmentActivity) {
        activity.startActivity(
            Intent(activity, AllUsersActivity::class.java)
        )
    }
}