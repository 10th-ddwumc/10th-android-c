package com.jihee.week2_mission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihee.week2_mission.databinding.ItemProductBinding

class ProductAdapter(
    private val list: List<ProductData>
) : RecyclerView.Adapter<ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder
    { val binding = ItemProductBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false )
        return ProductViewHolder(binding) }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = list[position]

        holder.bind(item)
    }

    override fun getItemCount() = list.size
}