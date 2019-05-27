package com.github.dzeko14.socialnetworkapp.view.fragment.abstracts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.dzeko14.socialnetworkapp.R

abstract class AbstractListFragment : Fragment() {

    abstract val rvAdapter: RecyclerView.Adapter<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = rvAdapter
        }
    }
}