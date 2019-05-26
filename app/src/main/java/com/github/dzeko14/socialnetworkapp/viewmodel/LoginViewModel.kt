package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.exception.LoginException
import com.github.dzeko14.socialnetworkapp.interactor.LoginUserInteractor
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.route.ActivityRoute
import com.github.dzeko14.socialnetworkapp.route.MainActivityRoute
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewModel(
    private val loginUserInteractor: LoginUserInteractor
) : CoroutineViewModel() {


    val login:  MutableLiveData<String> =  MutableLiveData()
    val password:  MutableLiveData<String> =  MutableLiveData()

    val route: MutableLiveData<ActivityRoute> = MutableLiveData()

    val state: MutableLiveData<State> = MutableLiveData()

    init {
        state.value = State.IDLE
    }

    fun login() {
        val lLogin = login.value ?: return
        val lPassword = login.value ?: return

        state.value = State.LOGIN_IN_PROCESS
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    loginUserInteractor.login(User(
                        login = lLogin,
                        password = lPassword))
                }
                route.value = MainActivityRoute()
                state.value = State.IDLE
            } catch (e: LoginException) {
                state.value = State.FAILED
            }
        }
    }

    enum class State {
        IDLE,
        LOGIN_IN_PROCESS,
        FAILED
    }
}
