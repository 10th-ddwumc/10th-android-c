package com.yogurt.umc_work02.ui.purchase

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PurchaseTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AllFragment()
            1 -> TopsFragment()
            2 -> ShoesFragment()
            else -> AllFragment()
        } as Fragment
    }
}