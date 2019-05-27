package com.github.dzeko14.socialnetworkapp.interactor.implementation

import android.util.Log
import com.github.dzeko14.socialnetworkapp.exception.LoginException
import com.github.dzeko14.socialnetworkapp.interactor.GetFriendsListInteractor
import com.github.dzeko14.socialnetworkapp.interactor.LoginUserInteractor
import com.github.dzeko14.socialnetworkapp.interactor.RegisterUserInteractor
import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.model.User
import javax.inject.Inject
import javax.inject.Singleton

private const val MOCK_USER_LOG="Mock_User_Log"

@Singleton
class MockUserInteractors @Inject constructor(

) : LoginUserInteractor, RegisterUserInteractor, GetFriendsListInteractor {
    override fun login(user: User) {
        if (user.login == "root" && user.password == "root")  {
            return
        } else {
            throw LoginException()
        }

    }

    override fun registerUser(user: User) {
        Log.d(MOCK_USER_LOG, user.toString())
    }

    override fun getFriendsList(): List<User> {
        return listOf(
            User(1, "esgsgr", "", "gergrg@gseg.c", "rsgsrgsgr"),
            User(2, "trtr", "", "wwwww@gseg.c", "aaaaa")
        )
    }
}