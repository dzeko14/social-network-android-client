package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.GetByIdInteractor
import com.github.dzeko14.socialnetworkapp.interactor.GetCurrentUserInfoInteractor
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDetailViewModel(
    private val getUserByIdInteractor: GetByIdInteractor<User, Long>,
    private val getCurrentUserInfoInteractor: GetCurrentUserInfoInteractor
) : CoroutineViewModel() {

    val user: MutableLiveData<User> = MutableLiveData()

    val isCurrentUser: MutableLiveData<Boolean> = MutableLiveData()

    fun getUserInfo(user_id: Long) {
        if (user.value != null) return

        viewModelScope.launch {
            user.value = withContext(Dispatchers.IO) {
                if (user_id == -1L) {
                    isCurrentUser.postValue(true)
                    getCurrentUserInfoInteractor.getCurrentUser()

                } else {
                    isCurrentUser.postValue(false)
                    getUserByIdInteractor.getById(user_id)

                }
            }
            val a = 0
        }
    }
}