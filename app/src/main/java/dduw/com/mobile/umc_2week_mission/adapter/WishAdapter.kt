package dduw.com.mobile.umc_2week_mission.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dduw.com.mobile.umc_2week_mission.data.WishData
import dduw.com.mobile.umc_2week_mission.databinding.WishItemBinding

class WishAdapter(
    private var wishList: MutableList<WishData>,
    private val onVisitClicked: (WishData) -> Unit
) : RecyclerView.Adapter<WishAdapter.WishViewHolder>() {
    inner class WishViewHolder(val binding: WishItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wish: WishData) {
            binding.wishImage.setImageResource(wish.buyImage)
            binding.wishItemName.text = wish.buyItemName
            binding.wishItemSub.text = wish.buyItemSub
            binding.wishItemColor.text = wish.buyItemColor
            binding.wishItemPrice.text = wish.buyItemPrice
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val binding = WishItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return WishViewHolder(binding)
    }
    override fun onBindViewHolder(holder: WishAdapter.WishViewHolder, position: Int) {
        val nowWish = wishList[position]
        holder.bind(nowWish)
    }
    override fun getItemCount(): Int {
        return wishList.size
    }
    fun updateList(newList: List<WishData>) {
        wishList.clear()
        wishList.addAll(newList)
        notifyDataSetChanged()
    }
}