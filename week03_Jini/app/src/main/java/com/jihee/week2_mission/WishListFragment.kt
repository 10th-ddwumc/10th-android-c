package com.jihee.week2_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.databinding.FragmentWishlistBinding

class WishListFragment : Fragment() {
    private lateinit var binding: FragmentWishlistBinding
    private val wishlist = mutableListOf<ProductData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wishlistRecyclerView()
    }
    private fun wishlistRecyclerView() {
        val items = listOf(
            ProductData(
                image = R.drawable.ic_jordan,
                name = "Air Jordan XXXVI",
                price = "$185"
            ),
            ProductData(
                image = R.drawable.ic_force,
                name = "Nike Air Force 1'08",
                price = "$115"
            )
        )

        binding.WishlistProduct.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = ProductAdapter(items)
        }
    }
}