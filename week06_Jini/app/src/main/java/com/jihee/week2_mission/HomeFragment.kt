package com.jihee.week2_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.week2_mission.data.repository.ProductRepositoryImpl
import com.jihee.week2_mission.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ProductAdapter
    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(ProductRepositoryImpl())
        )[ProductViewModel::class.java]

        adapter = ProductAdapter(emptyList()) { }

        binding.newProduct.adapter = adapter
        binding.newProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        lifecycleScope.launch {
            viewModel.getHomeProducts(requireContext()).collect { list ->

                if (list.isEmpty()) {
                    val dummy = listOf(
                        ProductData(R.drawable.ic_jordan, "Air Jordan XXXVI", "shoes", "shoes", "185$"),
                        ProductData(R.drawable.ic_force, "Nike Air Force 1'08", "shoes", "shoes", "115$")
                    )
                    viewModel.saveHomeProducts(requireContext(), dummy)
                } else {
                    adapter.updateList(list)
                }
            }
        }
    }
}