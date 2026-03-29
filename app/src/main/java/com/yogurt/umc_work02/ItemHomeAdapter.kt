package com.yogurt.umc_work02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogurt.umc_work02.databinding.ItemHomeBinding

class ItemHomeAdapter(private val itemList: List<ItemData>) :
    RecyclerView.Adapter<ItemHomeAdapter.ItemViewHolder>() {
        inner class ItemViewHolder(val binding: ItemHomeBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = itemList[position]
            holder.binding.ivItemImage.setImageResource(item.image)
            holder.binding.tvHomeItemName.text = item.name
            holder.binding.tvHomeItemPrice.text = item.price
        }

        override fun getItemCount(): Int {
            return itemList.size
        }
    }
