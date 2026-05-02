package com.jihee.week2_mission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jihee.week2_mission.databinding.ItemUserBinding

class UserAdapter(
    private var list: List<User>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemUserBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            Glide.with(binding.root)
                .load(user.avatar)
                .into(binding.ivProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun updateList(newList: List<User>) {
        list = newList
        notifyDataSetChanged()
    }
}