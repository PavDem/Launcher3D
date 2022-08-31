package com.demidenko.launcher3d.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demidenko.launcher3d.R
import com.demidenko.launcher3d.adapters.MyRecyclerViewAdapter
import com.demidenko.launcher3d.appsList
import com.demidenko.launcher3d.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */


class FirstFragment : Fragment() {

    private lateinit var adapter: MyRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    //private lateinit var appList: ArrayList<AppInfo>


    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var layoutmanager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_first)
        recyclerView.layoutManager = layoutmanager
        recyclerView.setHasFixedSize(false)
        adapter = MyRecyclerViewAdapter(activity as Activity) {
        }
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}