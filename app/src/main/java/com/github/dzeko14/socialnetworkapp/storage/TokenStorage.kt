package com.github.dzeko14.socialnetworkapp.storage

import com.github.dzeko14.socialnetworkapp.model.Token

interface TokenStorage {
    fun saveToken(token: Token)
    fun getToken(): Token
}