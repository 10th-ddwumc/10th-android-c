package com.yogurt.umc_work02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogurt.umc_work02.databinding.FragmentHomeBinding
import com.yogurt.umc_work02.databinding.FragmentPurchaseBinding


class PurchaseFragment : Fragment() {

    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf(
            ItemData(R.drawable.item5, "Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)", "US $123", 5),
            ItemData(R.drawable.item2, "Socks", "sample explain", "US $10", 7),
            ItemData(R.drawable.item3, "Nike Air Force 1 '07", "sample explain", "US $115", 5),
            ItemData(R.drawable.item4, "Jordan ENike Air Force 1 '07ssentials", "sample explain", "US $120", 2),
        )
        val mainAdapter = ItemMainAdapter(itemList)
        val gridLayoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)

        binding.rvMain.layoutManager = gridLayoutManager
        binding.rvMain.adapter = mainAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}