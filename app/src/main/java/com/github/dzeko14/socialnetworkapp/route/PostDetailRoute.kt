package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.PostDetailActivity

class PostDetailRoute(
    private val postId: Long
) : ActivityRoute {
    override fun execute(activity: FragmentActivity) {
        val intent = Intent(activity, PostDetailActivity::class.java).apply {
            putExtra(PostDetailActivity.POST_ID_KEY, postId)
        }
        activity.startActivity(intent)
    }
}