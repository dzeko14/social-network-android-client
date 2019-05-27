package com.github.dzeko14.socialnetworkapp.interactor.implementation

import com.github.dzeko14.socialnetworkapp.interactor.GetFriendsPostListInteractor
import com.github.dzeko14.socialnetworkapp.interactor.GetListInteractor
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.model.User
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockPostInteractors @Inject constructor(

) : GetFriendsPostListInteractor, GetListInteractor<Post> {

    private val posts: List<Post> = listOf(
        Post(1,
            "test",
            User(1,"eee", "eee", "wwww", "eee"),
            Date()),
        Post(2,
            "test, test",
            User(2,"aaa", "eee", "wwww", "aaa"),
            Date())
    )

    override fun getFriendsPostList(): List<Post> {
        return posts.filter {
            it.author.id == 2L
        }
    }

    override fun getList(): List<Post> {
        return posts
    }
}