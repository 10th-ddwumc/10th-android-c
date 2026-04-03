package com.yogurt.umc_work02.ui.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.data.local.datastore.ItemDataStore
import com.yogurt.umc_work02.data.model.ItemData
import com.yogurt.umc_work02.databinding.FragmentPurchaseBinding
import com.yogurt.umc_work02.ui.purchase.ItemPurchaseAdapter
import kotlinx.coroutines.launch

class PurchaseFragment : Fragment() {

    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemDataStore: ItemDataStore
    private lateinit var purchaseAdapter: ItemPurchaseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemDataStore = ItemDataStore(requireContext())
        purchaseAdapter = ItemPurchaseAdapter(emptyList()) {
            viewLifecycleOwner.lifecycleScope.launch {
                itemDataStore.saveItemData(itemDataStore.PURCHASE_DATA_KEY, purchaseAdapter.itemList)
            }
        }
//        val pagerAdapter = PurchaseTabAdapter(this)
//        binding.viewPager.adapter = pagerAdapter
//
//        val tabTitles = listOf("전체", "Tops & T-Shirts", "Shoes")
//
//        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
//            tab.text = tabTitles[position]
//        }.attach()
//
        val gridLayoutManager = GridLayoutManager(context, 2)

        binding.rvMain.layoutManager = gridLayoutManager
        binding.rvMain.adapter = purchaseAdapter

        observeItemData()
    }

    private fun saveInitialItemData() {
        val initialList = listOf(
            ItemData(
                1,
                R.drawable.item5,
                "Nike Everyday Plus Cushioned",
                "Training Ankle Socks (6 Pairs)",
                "US $123",
                5,
                false,
                false
            ),
            ItemData(2,R.drawable.item2, "Socks", "sample explain", "US $10", 7,false,false),
            ItemData(3,R.drawable.item3, "Nike Air Force 1 '07", "sample explain", "US $115", 5,true,false),
            ItemData(
                4,
                R.drawable.item4,
                "Jordan ENike Air Force 1 '07ssentials",
                "sample explain",
                "US $120",
                2,
                true,
                false
            ),
        )

        viewLifecycleOwner.lifecycleScope.launch {
            itemDataStore.saveItemData(itemDataStore.PURCHASE_DATA_KEY,initialList)
        }


    }

    private fun observeItemData() {
        viewLifecycleOwner.lifecycleScope.launch {
            itemDataStore.getItemDataFlow(itemDataStore.PURCHASE_DATA_KEY).collect { itemData ->
                if (itemData.isEmpty()) {
                    saveInitialItemData()
                } else {
                    purchaseAdapter.updateData(itemData)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}