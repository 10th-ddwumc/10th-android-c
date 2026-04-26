package com.jihee.week2_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductAdapter(emptyList()) { }

        binding.newProduct.adapter = adapter
        binding.newProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        lifecycleScope.launch {
            ProductDataStore.getHomeProducts(requireContext())
                .collect { list ->
                    if (list.isEmpty()) {
                        val dummy = listOf(
                            ProductData(R.drawable.ic_jordan, "Air Jordan XXXVI", "shoes","shoes","185$"),
                            ProductData(R.drawable.ic_force, "Nike Air Force 1'08", "shoes","shoes","115$")
                        )
                        ProductDataStore.saveHomeProducts(requireContext(), dummy)
                    }
                }
            }

        lifecycleScope.launch {
            ProductDataStore.getHomeProducts(requireContext())
                .collect { list ->
                    adapter.updateList(list)
                }
        }
    }
}
