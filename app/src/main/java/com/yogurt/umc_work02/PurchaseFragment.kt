package com.yogurt.umc_work02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}