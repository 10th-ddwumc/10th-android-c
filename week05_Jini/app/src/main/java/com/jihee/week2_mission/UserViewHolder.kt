package com.jihee.week2_mission

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jihee.week2_mission.databinding.ItemUserBinding

class UserViewHolder(
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        Glide.with(itemView.context)
            .load(user.avatar)
            .into(binding.ivProfile)
    }
}