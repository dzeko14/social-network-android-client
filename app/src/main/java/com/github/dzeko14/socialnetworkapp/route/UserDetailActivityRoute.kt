package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.UserDetailActivity

class UserDetailActivityRoute(
    private val userId: Long = -1
) : ActivityRoute {
    override fun execute(activity: FragmentActivity) {
        val intent = Intent(activity, UserDetailActivity::class.java)
            .apply {
                putExtra(UserDetailActivity.USER_ID_KEY, userId)
            }
        activity.startActivity(intent)
    }
}