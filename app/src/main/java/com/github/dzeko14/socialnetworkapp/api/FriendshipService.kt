package com.github.dzeko14.socialnetworkapp.api

import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface FriendshipService {
    @GET("/friends/{id}")
    fun getFriends(@Path("id") id: Long, @Body token: Token): Call<List<User>>

    @DELETE("/friends/{remover}/{target}")
    fun deleteFriendship(@Path("remover") remover: Long, @Path("target") target: Long,
                         @Body token: Token): Call<Unit>
}