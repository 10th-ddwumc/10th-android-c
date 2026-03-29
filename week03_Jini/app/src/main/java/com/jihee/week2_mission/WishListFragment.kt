package com.jihee.week2_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {
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

        wishlist.add(ProductData(R.drawable.ic_product1))
        wishlist.add(ProductData(R.drawable.ic_product4))

        val adapter = ProductAdapter(wishlist)
        binding.WishlistProduct.adapter = adapter
        binding.WishlistProduct.layoutManager =
        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}