package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.GetByIdInteractor
import com.github.dzeko14.socialnetworkapp.model.Post
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostDetailViewModel(
    private val getPostByIdInteractor: GetByIdInteractor<Post, Long>
) : CoroutineViewModel() {

    val post: MutableLiveData<Post> = MutableLiveData()

    fun getPost(postId: Long) {
        if (post.value != null) return

        viewModelScope.launch {
            post.value = withContext(Dispatchers.IO) {
                getPostByIdInteractor.getById(postId)
            }
        }
    }

    fun showComments(postId: Long) {

    }
}