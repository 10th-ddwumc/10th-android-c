package com.jihee.week2_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.databinding.FragmentWishlistBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WishListFragment : Fragment() {

    private lateinit var binding: FragmentWishlistBinding
    private lateinit var adapter: ProductAdapter

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

        adapter = ProductAdapter(emptyList()) { product ->

            lifecycleScope.launch {
                val currentList =
                    ProductDataStore.getWishlist(requireContext()).first().toMutableList()

                // 클릭하면 제거
                currentList.removeAll { it.name == product.name }

                ProductDataStore.saveWishlist(requireContext(), currentList)
            }
        }

        binding.WishlistProduct.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.WishlistProduct.adapter = adapter

        lifecycleScope.launch {
            ProductDataStore.getWishlist(requireContext())
                .collect { list ->
                    adapter.updateList(list)
                }
        }
    }
}