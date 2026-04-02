package com.jihee.week2_mission

import androidx.recyclerview.widget.RecyclerView
import com.jihee.week2_mission.databinding.ItemProductBinding

class ProductViewHolder(
    private val binding: ItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductData) {
        with(binding) {
            img.setImageResource(item.image)
            productName.text = item.name
            productPrice.text = item.price
        }
    }
}