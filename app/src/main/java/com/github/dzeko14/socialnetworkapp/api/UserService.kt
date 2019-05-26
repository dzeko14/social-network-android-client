package com.github.dzeko14.socialnetworkapp.api

import com.github.dzeko14.socialnetworkapp.model.*
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @POST("/users")
    fun registerUser(@Body user: User): Call<Unit>

    @GET("/users/id/{id}")
    fun getUserById(@Path("id") id: Long, @Body token: Token): Call<User>

    @GET("/users")
    fun getAllUsers(@Body token: Token): Call<List<User>>

    @PUT("/users")
    fun updateUserInfo(@Body tokenRequest: TokenRequest<UserUpdateInfo>): Call<Unit>

    @DELETE("/users")
    fun deleteUser(@Body tokenRequest: TokenRequest<User>): Call<Unit>

    @POST("/users/login")
    fun loginUser(@Body user: User): Call<Token>
}