package com.yogurt.umc_work02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogurt.umc_work02.databinding.ItemMainBinding

class ItemMainAdapter (private val itemList: List<ItemData>) :
    RecyclerView.Adapter<ItemMainAdapter.ItemViewHolder>() {
        inner class ItemViewHolder(val binding: ItemMainBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = itemList[position]
            holder.binding.ivItemThumbnail.setImageResource(item.image)
            holder.binding.tvItemExplain.text = item.explain
            holder.binding.tvItemName.text = item.name
            holder.binding.tvItemPrice.text = item.price
            holder.binding.tvItemColor.text = "${item.colorCount} Colours"
        }

        override fun getItemCount(): Int {
            return itemList.size
        }
    }