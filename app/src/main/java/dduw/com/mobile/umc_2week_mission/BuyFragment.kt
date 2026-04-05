package dduw.com.mobile.umc_2week_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dduw.com.mobile.umc_2week_mission.adapter.BuyAdapter
import dduw.com.mobile.umc_2week_mission.data.BuyData
import dduw.com.mobile.umc_2week_mission.data.WishData
import dduw.com.mobile.umc_2week_mission.dataStore.BuyDataStore
import dduw.com.mobile.umc_2week_mission.dataStore.WishDataStore
import dduw.com.mobile.umc_2week_mission.databinding.FragmentBuyBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class BuyFragment : Fragment() {
    private lateinit var binding: FragmentBuyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuyBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BuyAdapter(mutableListOf()) { item ->

            lifecycleScope.launch {
                val currentList = WishDataStore.getItems(requireContext())
                    .first()
                    .toMutableList()

                if (item.isLiked) {
                    if (currentList.none { it.buyItemName == item.buyItemName }) {
                        currentList.add(
                            WishData(
                                item.buyImage,
                                item.buyItemName,
                                item.buyItemSub,
                                item.buyItemColor,
                                item.buyItemPrice,
                                true
                            )
                        )
                    }
                } else {
                    currentList.removeAll { it.buyItemName == item.buyItemName }
                }

                WishDataStore.saveItems(requireContext(), currentList)
            }
        }

        binding.buyRecyclerView.adapter = adapter
        binding.buyRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        lifecycleScope.launch {
            val itemList = listOf(
                BuyData(R.drawable.buyitem,"Nike Everyday Plus Cushioned","Training Ankle Socks (6 Pairs)","5 Colours","US$10", false),
                BuyData(R.drawable.buyitem2,"Air Jordan 1 Mid","Training Ankle Socks (6 Pairs)","5 Colours","US$125", false),
            )

            BuyDataStore.saveItems(requireContext(), itemList)
        }
        lifecycleScope.launch {
            BuyDataStore.getItems(requireContext()).collect { buyList ->

                val wishList = WishDataStore.getItems(requireContext()).first()

                val newList = buyList.map { buyItem ->
                    buyItem.copy(
                        isLiked = wishList.any {
                            it.buyItemName == buyItem.buyItemName
                        }
                    )
                }

                adapter.updateList(newList)
            }
        }
    }
}
