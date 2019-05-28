package com.github.dzeko14.socialnetworkapp.model

import java.util.*

class Comment(
    val id: Long,
    val content: String,
    val post: Post,
    val date: Long,
    val author: User
)