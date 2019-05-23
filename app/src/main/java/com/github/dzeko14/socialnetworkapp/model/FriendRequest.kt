package com.github.dzeko14.socialnetworkapp.model

class FriendRequest(
        val id: Long,

        val sender: User,

        val receiver: User,

        val date: Long
)