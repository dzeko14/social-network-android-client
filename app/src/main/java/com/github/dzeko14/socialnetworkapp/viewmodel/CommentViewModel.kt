package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.interactor.CreateCommentInteractor
import com.github.dzeko14.socialnetworkapp.interactor.CrudInteractor
import com.github.dzeko14.socialnetworkapp.interactor.GetCommentsByPostInteractor
import com.github.dzeko14.socialnetworkapp.model.Comment
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CommentViewModel(
    private val getCommentsByPostInteractor: GetCommentsByPostInteractor,
    private val createCommentInteractor: CreateCommentInteractor
) : CoroutineViewModel() {

    val content: MutableLiveData<String> = MutableLiveData()

    val comments: MutableLiveData<List<Comment>> = MutableLiveData()

    private var postId: Long = -1

    fun getComments(postId: Long) {
        val size = comments.value?.size
        if (size != null && size > 0) return
        this.postId = postId
        viewModelScope.launch {
            comments.value = withContext(Dispatchers.IO) {
                getCommentsByPostInteractor.getCommentsByPost(postId)
            }
        }
    }

    fun createComment() {
        val content = this.content.value ?: return
        if (postId == -1L) return
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                createCommentInteractor.createComment(content, postId)
            }
            comments.value = withContext(Dispatchers.IO) {
                getCommentsByPostInteractor.getCommentsByPost(postId)
            }
        }
    }
}