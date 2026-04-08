package dduw.com.mobile.umc_2week_mission.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dduw.com.mobile.umc_2week_mission.R
import dduw.com.mobile.umc_2week_mission.data.BuyData
import dduw.com.mobile.umc_2week_mission.databinding.BuyItemBinding

class BuyAdapter(
    private var buyList: MutableList<BuyData>,
    private val onVisitClicked: (BuyData) -> Unit
) : RecyclerView.Adapter<BuyAdapter.BuyViewHolder>() {
    inner class BuyViewHolder(val binding: BuyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(buy: BuyData) {
            binding.buyImage.setImageResource(buy.buyImage)
            binding.buyItemName.text = buy.buyItemName
            binding.buyItemSub.text = buy.buyItemSub
            binding.buyItemColor.text = buy.buyItemColor
            binding.buyItemPrice.text = buy.buyItemPrice

            binding.heartBtn.setImageResource(
                if (buy.isLiked) R.drawable.full_heart
                else R.drawable.empty_heart
            )

            binding.heartBtn.setOnClickListener {
                buy.isLiked = !buy.isLiked
                onVisitClicked(buy)

                notifyItemChanged(adapterPosition)

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyViewHolder {
        val binding = BuyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return BuyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: BuyAdapter.BuyViewHolder, position: Int) {
        val nowBuy = buyList[position]
        holder.bind(nowBuy)
    }
    override fun getItemCount(): Int {
        return buyList.size
    }

    fun updateList(newList: List<BuyData>) {
        buyList.clear()
        buyList.addAll(newList)
        notifyDataSetChanged()
    }
}