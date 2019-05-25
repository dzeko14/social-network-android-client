package com.github.dzeko14.socialnetworkapp.storage.implementation

import android.content.SharedPreferences
import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import com.github.dzeko14.socialnetworkapp.exception.NoTokenException
import javax.inject.Inject
import javax.inject.Singleton

private const val TOKEN_KEY = "token_key"

@Singleton
class TokenStorageImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : TokenStorage {
    override fun saveToken(token: Token) {
        with(sharedPreferences.edit()) {
            putString(TOKEN_KEY, token.value)
            apply()
        }
    }

    override fun getToken(): Token {
        val tokenStr = sharedPreferences.getString(TOKEN_KEY, "")!!
        if (tokenStr.isEmpty()) throw NoTokenException()

        return Token(tokenStr)
    }
}