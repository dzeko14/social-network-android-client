package com.github.dzeko14.socialnetworkapp.interactor.implementation

import com.github.dzeko14.socialnetworkapp.exception.LoginException
import com.github.dzeko14.socialnetworkapp.interactor.LoginUserInteractor
import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockUserInteractors @Inject constructor(

) : LoginUserInteractor {
    override fun login(user: User) {
        if (user.login == "root" && user.password == "root")  {
            return
        } else {
            throw LoginException()
        }

    }
}