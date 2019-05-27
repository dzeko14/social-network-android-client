package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.GetListInteractor
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostListViewModel(
    private val getPostListInteractor: GetListInteractor<Post>
) : CoroutineViewModel() {

    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPosts() {
        val size = posts.value?.size
        if (size != null && size > 0) return

        viewModelScope.launch {
            posts.value = withContext(Dispatchers.IO) {
                getPostListInteractor.getList()
            }
        }
    }
}