package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.GetFriendsListInteractor
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FriendListViewModel(
    private val getFriendsListInteractor: GetFriendsListInteractor
) : CoroutineViewModel() {

    val friends: MutableLiveData<List<User>> = MutableLiveData()

    fun getFriends() {
        val size = friends.value?.size
        if (size != null && size > 0) return

        viewModelScope.launch {
            friends.value = withContext(Dispatchers.IO) {
                getFriendsListInteractor.getFriendsList()
            }
        }
    }

}