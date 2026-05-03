package com.yogurt.umc_work02.ui.purchase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.data.model.ItemData
import com.yogurt.umc_work02.databinding.ItemMainBinding

class ItemPurchaseAdapter (
    var itemList: List<ItemData>,
    private val isHeartVisible: Boolean = true,
    val onHeartClicked: () -> Unit
) : RecyclerView.Adapter<ItemPurchaseAdapter.ItemViewHolder>() {
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

            if (item.isWish) {
                holder.binding.btnWish.setImageResource(R.drawable.heart_filled)
            } else {
                holder.binding.btnWish.setImageResource(R.drawable.heartstraight)
            }

            if (item.isBestSeller) {
                holder.binding.tvBestSeller.visibility = View.VISIBLE
            } else {
                holder.binding.tvBestSeller.visibility = View.GONE
            }

            holder.binding.btnWish.setOnClickListener {
                item.isWish = !item.isWish

                if (item.isWish) {
                    holder.binding.btnWish.setImageResource(R.drawable.heart_filled)
                }
                onHeartClicked()
            }

            if (isHeartVisible) {
                holder.binding.btnWish.visibility = View.VISIBLE
            } else {
                holder.binding.btnWish.visibility = View.GONE
            }
        }


        fun updateData(newData: List<ItemData>) {
            this.itemList = newData
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

    }