package dduw.com.mobile.umc_2week_mission.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dduw.com.mobile.umc_2week_mission.data.ItemData
import dduw.com.mobile.umc_2week_mission.databinding.NewItemBinding

class ItemAdapter(
    private var itemList: MutableList<ItemData>,
    private val onVisitClicked: (ItemData) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: NewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemData) {
            binding.itemName.text = item.itemName
            binding.itemPrice.text = item.itemPrice
            binding.itemimg.setImageResource(item.itemImage)
            binding.root.setOnClickListener {
                onVisitClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = NewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}