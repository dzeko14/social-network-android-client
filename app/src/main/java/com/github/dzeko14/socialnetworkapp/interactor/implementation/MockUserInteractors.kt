package com.github.dzeko14.socialnetworkapp.interactor.implementation

import android.util.Log
import com.github.dzeko14.socialnetworkapp.exception.LoginException
import com.github.dzeko14.socialnetworkapp.interactor.*
import com.github.dzeko14.socialnetworkapp.model.Token
import com.github.dzeko14.socialnetworkapp.model.User
import javax.inject.Inject
import javax.inject.Singleton

private const val MOCK_USER_LOG="Mock_User_Log"

@Singleton
class MockUserInteractors @Inject constructor(

) : LoginUserInteractor, RegisterUserInteractor, GetFriendsListInteractor,
GetByIdInteractor<User, Long>, GetCurrentUserInfoInteractor, GetListInteractor<User> {

    override fun getList(): List<User> {
        return listOf(
            User(1, "esgsgr", "", "gergrg@gseg.c", "rsgsrgsgr"),
            User(2, "trtr", "", "wwwww@gseg.c", "aaaaa")
        )
    }

    override fun getById(id: Long): User {
        return User(3, "guest", "", "rgr@w.com", "guest")
    }

    override fun getCurrentUser(): User {
        return User(1, "root", "", "rgr@w.com", "root")
    }

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