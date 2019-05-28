package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.model.User
import com.github.dzeko14.socialnetworkapp.route.UserDetailActivityRoute
import com.github.dzeko14.socialnetworkapp.view.adapter.FriendsListRecyclerViewAdapter
import com.github.dzeko14.socialnetworkapp.viewmodel.AllUsersViewModel
import javax.inject.Inject

class AllUsersActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AllUsersViewModel

    private val rvAdapter: FriendsListRecyclerViewAdapter
            = FriendsListRecyclerViewAdapter(::selectUserCallback)

    init {
        App.appComponent.provideAllUsersActivity(this)
    }

    private fun selectUserCallback(user: User) {
        UserDetailActivityRoute(user.id).execute(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_friends_list)

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AllUsersViewModel::class.java)

        viewModel.users.observe(this, Observer {
            it?.let { friends ->
                rvAdapter.updateFriendList(friends)
            }
        })

        viewModel.getUsers()
    }
}
