package com.github.dzeko14.socialnetworkapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.dzeko14.socialnetworkapp.R
import com.github.dzeko14.socialnetworkapp.application.App
import com.github.dzeko14.socialnetworkapp.view.fragment.FriendsListFragment
import com.github.dzeko14.socialnetworkapp.view.fragment.FriendsPostListFragment
import com.github.dzeko14.socialnetworkapp.view.fragment.PostListFragment
import com.github.dzeko14.socialnetworkapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    private lateinit var drawerLayout: DrawerLayout

    init {
        App.appComponent.provideMainActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        bottom_nav_view.setOnNavigationItemSelectedListener {
            viewModel.updateFragmentContainer(it.itemId)
            true
        }

        viewModel.currentFragment.observe(this, Observer {
            val fragment = when(it) {
                R.id.friends -> FriendsListFragment.create()

                R.id.posts -> PostListFragment.create()

                R.id.friends_posts -> FriendsPostListFragment.create()

                else -> return@Observer
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        })

        setSupportActionBar(findViewById(R.id.tool_bar))
        supportActionBar.apply {
            this?.let {
                setDisplayHomeAsUpEnabled(true)
                setHomeAsUpIndicator(R.drawable.ic_reorder)
            }
        }

        drawerLayout = findViewById(R.id.drawer_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) return super.onOptionsItemSelected(item)

        when(item.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }
}
