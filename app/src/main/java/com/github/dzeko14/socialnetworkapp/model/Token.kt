package com.github.dzeko14.socialnetworkapp.model

class Token (
        val value: String
) {
    companion object {
        fun empty(): Token {
            return Token("")
        }
    }
}