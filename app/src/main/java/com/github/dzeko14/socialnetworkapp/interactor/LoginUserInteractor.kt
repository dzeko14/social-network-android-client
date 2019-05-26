package com.github.dzeko14.socialnetworkapp.interactor

import com.github.dzeko14.socialnetworkapp.model.User

interface LoginUserInteractor {
    fun login(user: User)
}