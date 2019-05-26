package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.RegisterUserInteractor
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(
    private val registerUserInteractor: RegisterUserInteractor
) : CoroutineViewModel() {
    val login: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val name: MutableLiveData<String> = MutableLiveData()

    val state: MutableLiveData<State> = MutableLiveData()

    init {
        state.value = State.IDLE
    }

    fun register() {
        val lLogin = login.value ?: return
        val lPassword = password.value ?: return
        val lEmail = email.value ?: return
        val lName = name.value ?: return

        val user = User(
            login = lLogin,
            password = lPassword,
            email = lEmail,
            name = lName
        )

        viewModelScope.launch {
            state.value = State.IN_PROGRESS
            try {
                withContext(Dispatchers.IO) {
                    registerUserInteractor.registerUser(user)
                }
                state.value = State.COMPLETE
            } catch (e: Exception) {
                state.value = State.ERROR
            }
        }
    }

    enum class State {
        IDLE,
        ERROR,
        IN_PROGRESS,
        COMPLETE
    }
}