package com.github.dzeko14.socialnetworkapp.model

import java.util.*

data class Post(
    val id: Long,
    val content: String,
    val author: User,
    val date: Date
) {
}