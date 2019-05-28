package com.github.dzeko14.socialnetworkapp.interactor

interface CreateCommentInteractor {
    fun createComment(content: String, postId: Long)
}