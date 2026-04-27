package com.jihee.week2_mission

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.Orderbutton)

        button.setOnClickListener {
            (activity as? MainActivity)?.navigateToBottomTab(R.id.purchase)
        }
    }
}