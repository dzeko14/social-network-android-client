package com.github.dzeko14.socialnetworkapp.interactor.implementation

import com.github.dzeko14.socialnetworkapp.interactor.CreateCommentInteractor
import com.github.dzeko14.socialnetworkapp.interactor.CrudInteractor
import com.github.dzeko14.socialnetworkapp.interactor.GetCommentsByPostInteractor
import com.github.dzeko14.socialnetworkapp.model.Comment
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.model.User
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockCommentInteractor @Inject constructor() : CreateCommentInteractor,
GetCommentsByPostInteractor{

    private val comments = mutableListOf<Comment>()

    override fun createComment(content: String, postId: Long) {
        comments.add(
            Comment(0, content,
                Post(postId, "", User(0, "", "", "", ""), Date()),
                Date().time,
                User(0, "", "", "", ""))
        )
    }

    override fun getCommentsByPost(postId: Long): List<Comment> {
        return comments.filter {comment ->
            comment.post.id == postId
        }
    }
}