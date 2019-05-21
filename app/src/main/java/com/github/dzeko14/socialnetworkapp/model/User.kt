package com.github.dzeko14.socialnetworkapp.model


data class User(
        val id: Long = 0,
        val login: String,
        val password: String = "",
        val email: String = "",
        val name: String = ""
)