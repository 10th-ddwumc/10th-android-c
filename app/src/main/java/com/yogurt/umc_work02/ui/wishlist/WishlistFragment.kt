package com.yogurt.umc_work02.ui.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.data.local.datastore.ItemDataStore
import com.yogurt.umc_work02.data.model.ItemData
import com.yogurt.umc_work02.databinding.FragmentWishlistBinding
import com.yogurt.umc_work02.ui.purchase.ItemPurchaseAdapter
import kotlinx.coroutines.launch

class WishlistFragment : Fragment() {
    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!
    private lateinit var wishAdapter: ItemPurchaseAdapter
    private lateinit var itemDataStore: ItemDataStore


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

        itemDataStore = ItemDataStore(requireContext())

        wishAdapter = ItemPurchaseAdapter(emptyList(),false) {

        }

        val gridLayoutManager = GridLayoutManager(context, 2)

        binding.rvWish.layoutManager = gridLayoutManager
        binding.rvWish.adapter = wishAdapter

        observeWishlistData()
    }

    private fun observeWishlistData() {
        viewLifecycleOwner.lifecycleScope.launch {
            itemDataStore.getItemDataFlow(itemDataStore.PURCHASE_DATA_KEY).collect { fullList ->
                val wishlist = fullList.filter { it.isWish }
                wishAdapter.updateData(wishlist)
            }
        }
    }
}