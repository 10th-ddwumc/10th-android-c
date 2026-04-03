package com.yogurt.umc_work02.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.databinding.FragmentCartBinding
import com.yogurt.umc_work02.ui.main.MainActivity

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toOrder.setOnClickListener {
            (activity as? MainActivity)?.changeFragment(R.id.nav_purchase)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}