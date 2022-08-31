package com.demidenko.launcher3d.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demidenko.launcher3d.fragments.FirstFragment
import com.demidenko.launcher3d.fragments.SecondFragment

class MyFragmentViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->  FirstFragment()
            1 ->  SecondFragment()
            else ->  FirstFragment()
        }
    }
}