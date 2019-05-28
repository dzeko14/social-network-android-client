package com.github.dzeko14.socialnetworkapp.route

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.github.dzeko14.socialnetworkapp.view.activity.CommentsActivity

class CommentActivityRoute(private val postId: Long): ActivityRoute
{
    override fun execute(activity: FragmentActivity) {
        val intent = Intent(activity, CommentsActivity::class.java)
        intent.putExtra(CommentsActivity.POST_ID_KEY, postId)
        activity.startActivity(intent)
    }
}