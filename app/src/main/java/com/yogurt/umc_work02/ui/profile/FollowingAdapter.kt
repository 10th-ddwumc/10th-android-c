package com.yogurt.umc_work02.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.data.model.UserData
import com.yogurt.umc_work02.databinding.ItemFollowBinding

class FollowingAdapter (private var userList: List<UserData> = emptyList()) :
    RecyclerView.Adapter<FollowingAdapter.FollowViewHolder>() {
    inner class FollowViewHolder(val binding: ItemFollowBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun updateData(newList: List<UserData>) {
        userList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): FollowingAdapter.FollowViewHolder {
        val binding = ItemFollowBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return FollowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowingAdapter.FollowViewHolder, p1: Int) {
        val user = userList[p1]

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .into(holder.binding.ivFollow)
    }

    override fun getItemCount() = userList.size

}