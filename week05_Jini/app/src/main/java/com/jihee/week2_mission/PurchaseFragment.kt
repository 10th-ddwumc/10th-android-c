package com.jihee.week2_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.databinding.FragmentPurchaseBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class PurchaseFragment : Fragment() {
    private lateinit var binding: FragmentPurchaseBinding
    private lateinit var adapter: ProductAdapter

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

        adapter = ProductAdapter(emptyList()) { product ->

            lifecycleScope.launch {

                val currentList =
                    ProductDataStore.getWishlist(requireContext()).first().toMutableList()

                val exists = currentList.any { it.name == product.name }

                if (exists) {
                    currentList.removeAll { it.name == product.name }
                } else {
                    currentList.add(product.copy(heart = true))
                }

                ProductDataStore.saveWishlist(requireContext(), currentList)

                val productList =
                    ProductDataStore.getProducts(requireContext()).first()

                val updatedList = productList.map {
                    if (currentList.any { w -> w.name == it.name }) {
                        it.copy(heart = true)
                    } else {
                        it.copy(heart = false)
                    }
                }

                adapter.updateList(updatedList)
            }
        }

        binding.allProduct.adapter = adapter
        binding.allProduct.layoutManager = GridLayoutManager(requireContext(), 2)

        lifecycleScope.launch {
            ProductDataStore.getProducts(requireContext())
                .collect { list ->
                    if (list.isEmpty()) {
                        val dummy = listOf(
                            ProductData(R.drawable.ic_product1,"Nike Everyday Plus Cushioned",
                                "Training Ankle Socks(6Pairs)","5colours","10$",false,false),
                            ProductData(R.drawable.ic_product2,"Nike Everyday Plus",
                                "Training Ankle Socks(6Pairs)","5colours","10$",false,false),
                            ProductData(R.drawable.ic_product3,"Nike Air Force","Shoes",
                                "5colours","115$",false,true),
                            ProductData(R.drawable.ic_product5,"Jordan Nike",
                                "Socks","5colours","20$",false,true)
                        )
                        ProductDataStore.saveProducts(requireContext(), dummy)
                    }
                }
        }

        lifecycleScope.launch {

            ProductDataStore.getProducts(requireContext()).collect { productList ->

                val wishlist =
                    ProductDataStore.getWishlist(requireContext()).first()

                val updatedList = productList.map { product ->
                    if (wishlist.any { it.name == product.name }) {
                        product.copy(heart = true)
                    } else {
                        product.copy(heart = false)
                    }
                }

                adapter.updateList(updatedList)
            }
        }
    }
}