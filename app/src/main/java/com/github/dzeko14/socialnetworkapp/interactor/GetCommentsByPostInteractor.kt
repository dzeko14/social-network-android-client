package com.github.dzeko14.socialnetworkapp.interactor

import com.github.dzeko14.socialnetworkapp.model.Comment

interface GetCommentsByPostInteractor {
    fun getCommentsByPost(postId: Long): List<Comment>
}