package com.jihee.week2_mission

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.jihee.week2_mission.databinding.ItemProductBinding

class ProductViewHolder(
    private val binding: ItemProductBinding,
    private val onHeartClick: (ProductData) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductData) {
        with(binding) {
            img.setImageResource(item.image)
            productName.text = item.name
            productPrice.text = item.price
        }

        if (item.heart) {
            binding.icHeart.setImageResource(R.drawable.ic_redheart)
        } else {
            binding.icHeart.setImageResource(R.drawable.ic_heartstraight)
        }

        binding.icHeart.setOnClickListener {
            onHeartClick(item)
        }
    }
}