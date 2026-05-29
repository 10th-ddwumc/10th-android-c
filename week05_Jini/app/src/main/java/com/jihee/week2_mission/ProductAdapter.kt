package com.jihee.week2_mission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihee.week2_mission.databinding.ItemProductBinding

class ProductAdapter(
    private var list: List<ProductData>,
    private val onHeartClick: (ProductData) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder
    { val binding = ItemProductBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false )
        return ProductViewHolder(binding, onHeartClick) }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun updateList(newList: List<ProductData>) {
        list = newList
        notifyDataSetChanged()
    }
}