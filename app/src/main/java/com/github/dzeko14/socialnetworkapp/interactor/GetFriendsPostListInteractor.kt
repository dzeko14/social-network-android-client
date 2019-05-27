package com.github.dzeko14.socialnetworkapp.interactor

import com.github.dzeko14.socialnetworkapp.model.Post

interface GetFriendsPostListInteractor {
    fun getFriendsPostList(): List<Post>
}