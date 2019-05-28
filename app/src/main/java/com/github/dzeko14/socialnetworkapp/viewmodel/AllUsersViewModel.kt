package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.GetListInteractor
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllUsersViewModel(
    private val getUsersInteractor: GetListInteractor<User>
) : CoroutineViewModel() {

    val users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers() {
        val size = users.value?.size
        if (size != null && size > 0) return
        viewModelScope.launch {
            users.value = withContext(Dispatchers.IO) {
                getUsersInteractor.getList()
            }
        }
    }
}