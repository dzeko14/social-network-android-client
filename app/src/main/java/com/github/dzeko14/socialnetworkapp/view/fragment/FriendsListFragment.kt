package com.github.dzeko14.socialnetworkapp.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.view.adapter.FriendsListRecyclerViewAdapter
import com.github.dzeko14.socialnetworkapp.viewmodel.FriendListViewModel
import javax.inject.Inject

class FriendsListFragment : AbstractListFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FriendListViewModel

    override val rvAdapter: FriendsListRecyclerViewAdapter = FriendsListRecyclerViewAdapter()

    init {
        App.appComponent.provideFriendListFragment(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(FriendListViewModel::class.java)

        viewModel.friends.observe(this, Observer {
            it?.let { friends ->
                rvAdapter.updateFriendList(friends)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFriends()
    }

    companion object {
        fun create(): FriendsListFragment {
            return FriendsListFragment()
        }
    }
}
