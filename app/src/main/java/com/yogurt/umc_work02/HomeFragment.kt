package com.yogurt.umc_work02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogurt.umc_work02.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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
        val itemList = listOf(
            ItemData(R.drawable.item1, "Air Jordan", "sample explain", "US $123", 1),
            ItemData(R.drawable.item2, "Socks", "sample explain", "US $10", 1),
            ItemData(R.drawable.item3, "Nike Air Force 1 '07", "sample explain", "US $115", 1),
            ItemData(R.drawable.item4, "Jordan Essentials", "sample explain", "US $120", 1),
            )
        val homeAdapter = ItemHomeAdapter(itemList)
        binding.recyclerView.apply {
            this.adapter = homeAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

    }

}