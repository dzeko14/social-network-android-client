package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.GetFriendsPostListInteractor
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FriendsPostListViewModel(
    private val getFriendsPostListInteractor: GetFriendsPostListInteractor
) : CoroutineViewModel() {
    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun getFriendsPosts() {
        val size = posts.value?.size
        if (size != null && size > 0) return

        viewModelScope.launch {
            posts.value = withContext(Dispatchers.IO) {
                getFriendsPostListInteractor.getFriendsPostList()
            }
        }
    }
}