package com.github.dzeko14.socialnetworkapp.api

import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.model.TokenRequest
import retrofit2.Call
import retrofit2.http.*

interface PostService {
    @POST("/posts")
    fun createPost(@Body tokenRequest: TokenRequest<Post>): Call<Unit>

    @DELETE("/posts/{id}")
    fun deletePost(@Path("id") id: Long, @Body token: Token): Call<Unit>

    @GET("/posts")
    fun getAllPosts(@Body token: Token): Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: Long, @Body token: Token): Call<Post>

    @PUT("/posts")
    fun updatePost(@Body tokenRequest: TokenRequest<Post>): Call<Unit>

    @GET("/posts/user/{id}")
    fun getUserPosts(@Path("id") id: Long, @Body token: Token): Call<List<Post>>

    @GET("/posts/user/{id}/friends")
    fun getUserFriendsPosts(@Path("id")id: Long, @Body token: Token): Call<List<Post>>
}