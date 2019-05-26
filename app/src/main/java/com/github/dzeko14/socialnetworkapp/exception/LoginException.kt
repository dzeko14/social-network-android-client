package com.github.dzeko14.socialnetworkapp.exception

class LoginException(private val msg: String = ""): Exception() {
    override val message: String?
        get() = msg
}