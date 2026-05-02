package com.jihee.week2_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.databinding.FragmentPurchaseBinding

class PurchaseFragment : Fragment() {
    private lateinit var binding: FragmentPurchaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf(
            ProductData(R.drawable.ic_product1,"Nike Elite Creq","16$"),
            ProductData(R.drawable.ic_product2,"Nike Everyday Plus Cushioned","10$"),
            ProductData(R.drawable.ic_product3,"Nike Air Force woman","115$"),
            ProductData(R.drawable.ic_product5,"Jordan ENike Air Force","115$")
        )

        val adapter = ProductAdapter(list)

        binding.allProduct.adapter = adapter
        binding.allProduct.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}