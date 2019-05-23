package com.github.dzeko14.socialnetworkapp.api

import com.github.dzeko14.socialnetworkapp.model.FriendRequest
import com.github.dzeko14.socialnetworkapp.model.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FriendRequestService {
    @POST("/friendRequest/create/{requester}/{target}")
    fun makeFriendRequest(@Path("requester") requesterId: Long,
                          @Path("target") target: Long,
                          @Body token: Token): Call<Unit>

    @POST("/friendRequest/approve/{id}")
    fun approveFriendRequest(@Path("id") id: Long,
                             @Body token: Token): Call<Unit>

    @POST("/friendRequest/deny/{id}")
    fun denyFriendRequest(@Path("id") id: Long, @Body token: Token): Call<Unit>

    @GET("/friendRequest/receiver/{id}")
    fun getUserFriendRequests(@Path("id") id: Long, @Body token: Token): Call<List<FriendRequest>>
}