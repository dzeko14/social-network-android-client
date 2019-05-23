package com.github.dzeko14.socialnetworkapp.api

import com.github.dzeko14.socialnetworkapp.model.Comment
import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.model.TokenRequest
import retrofit2.Call
import retrofit2.http.*

interface CommentService {
    @POST("/comments")
    fun createComment(@Body tokenRequest: TokenRequest<Comment>): Call<Comment>

    @DELETE("/comments/{id}")
    fun feleteComment(@Path("id") id: Long, @Body token: Token): Call<Unit>

    @GET("/comments")
    fun getAllComments(@Body token: Token): Call<List<Comment>>

    @GET("/comments/{id}")
    fun getCommentById(@Path("id") id: Long, @Body token: Token): Call<Comment>

    @PUT("/comments")
    fun updateComment(@Body comment: TokenRequest<Comment>): Call<Unit>

    @GET("/comments/post/{id}")
    fun getPostComments(@Path("id") id: Long, @Body token: Token): Call<List<Comment>>
}