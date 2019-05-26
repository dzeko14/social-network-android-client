package com.github.dzeko14.socialnetworkapp.interactor

import com.github.dzeko14.socialnetworkapp.model.User

interface RegisterUserInteractor {
    fun registerUser(user: User)
}