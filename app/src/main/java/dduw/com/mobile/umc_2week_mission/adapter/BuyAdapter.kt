package dduw.com.mobile.umc_2week_mission.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dduw.com.mobile.umc_2week_mission.data.BuyData
import dduw.com.mobile.umc_2week_mission.databinding.BuyItemBinding

class BuyAdapter(
    private var buyList: MutableList<BuyData>,
    private val onVisitClicked: (BuyData) -> Unit
) : RecyclerView.Adapter<BuyAdapter.FriendViewHolder>() {
    inner class FriendViewHolder(val binding: BuyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(buy: BuyData) {

            binding.buyImage.setImageResource(buy.buyImage)
            binding.buyItemName.text = buy.buyItemName
            binding.buyItemSub.text = buy.buyItemSub
            binding.buyItemColor.text = buy.buyItemColor
            binding.buyItemPrice.text = buy.buyItemPrice
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = BuyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return FriendViewHolder(binding)
    }
    override fun onBindViewHolder(holder: BuyAdapter.FriendViewHolder, position: Int) {
        val nowBuy = buyList[position]
        holder.bind(nowBuy)
    }
    override fun getItemCount(): Int {
        return buyList.size
    }

}