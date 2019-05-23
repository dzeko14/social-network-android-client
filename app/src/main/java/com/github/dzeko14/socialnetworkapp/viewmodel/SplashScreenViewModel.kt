package com.github.dzeko14.socialnetworkapp.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dzeko14.socialnetworkapp.exception.NoTokenException
import com.github.dzeko14.socialnetworkapp.route.ActivityRoute
import com.github.dzeko14.socialnetworkapp.route.LoginActivityRoute
import com.github.dzeko14.socialnetworkapp.route.MainActivityRoute
import com.github.dzeko14.socialnetworkapp.storage.TokenStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val tokenStorage: TokenStorage
) : ViewModel() {
    private val uiContext = CoroutineScope(Dispatchers.Main)

    val liveData: MutableLiveData<ActivityRoute> = MutableLiveData()

    fun resolveRoute() {
        uiContext.launch {
            delay(1000)
            try {
                tokenStorage.getToken()
                liveData.value = MainActivityRoute()
            } catch (e: NoTokenException) {
                liveData.value = LoginActivityRoute()
            }
        }

    }
}