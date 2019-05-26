package com.github.dzeko14.socialnetworkapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.viewmodel.abstracts.CoroutineViewModel

class MainViewModel : CoroutineViewModel() {

    private val _currentFragment = MutableLiveData<Int>()
    val currentFragment: LiveData<Int>
        get() = _currentFragment

    init {
        _currentFragment.value = R.id.friends
    }

    fun updateFragmentContainer(menuItemId: Int) {
        if(_currentFragment.value == menuItemId) return

        _currentFragment.value = when(menuItemId) {
            R.id.posts ->  menuItemId

            R.id.friends_posts -> menuItemId

            R.id.friends -> menuItemId

            else -> return
        }
    }
}