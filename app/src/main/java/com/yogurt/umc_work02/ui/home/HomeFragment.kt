package com.yogurt.umc_work02.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.data.local.datastore.ItemDataStore
import com.yogurt.umc_work02.data.model.ItemData
import com.yogurt.umc_work02.databinding.FragmentHomeBinding
import com.yogurt.umc_work02.ui.home.ItemHomeAdapter
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemDataStore: ItemDataStore
    private lateinit var homeAdapter: ItemHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemDataStore = ItemDataStore(requireContext())
        homeAdapter = ItemHomeAdapter(emptyList())

        binding.recyclerView.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        saveInitialItemData()
        observeItemData()
    }

    private fun saveInitialItemData() {

        val initialList = listOf(
            ItemData(1, R.drawable.item1, "Air Jordan", "sample explain", "US $185", 1, false, false),
            ItemData(2,R.drawable.item3, "Nike Air Force 1 '07", "sample explain", "US $115", 1, false, false),
        )

        viewLifecycleOwner.lifecycleScope.launch {
            itemDataStore.saveItemData(itemDataStore.ITEM_DATA_KEY,initialList)
        }

    }

    private fun observeItemData() {
        viewLifecycleOwner.lifecycleScope.launch {
            itemDataStore.getItemDataFlow(itemDataStore.ITEM_DATA_KEY).collect { itemData ->
                if (itemData.isNotEmpty()) {
                    homeAdapter.updateData(itemData)
                }
            }
                }
    }

}