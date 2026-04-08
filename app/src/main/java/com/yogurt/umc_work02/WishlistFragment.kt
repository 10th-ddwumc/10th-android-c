package com.yogurt.umc_work02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yogurt.umc_work02.databinding.FragmentHomeBinding
import com.yogurt.umc_work02.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {
    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf(
            ItemData(R.drawable.item5, "Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)", "US $123", 5),
            ItemData(R.drawable.item2, "Socks", "sample explain", "US $10", 7),
        )
        val mainAdapter = ItemWishAdapter(itemList)
        val gridLayoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)

        binding.rvWish.layoutManager = gridLayoutManager
        binding.rvWish.adapter = mainAdapter

    }
}