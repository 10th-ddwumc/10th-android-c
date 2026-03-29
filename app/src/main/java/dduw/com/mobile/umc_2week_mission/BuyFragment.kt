package dduw.com.mobile.umc_2week_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dduw.com.mobile.umc_2week_mission.adapter.BuyAdapter
import dduw.com.mobile.umc_2week_mission.adapter.ItemAdapter
import dduw.com.mobile.umc_2week_mission.data.BuyData
import dduw.com.mobile.umc_2week_mission.data.ItemData
import dduw.com.mobile.umc_2week_mission.databinding.FragmentBagBinding
import dduw.com.mobile.umc_2week_mission.databinding.FragmentBuyBinding

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

        val buyList = mutableListOf(
            BuyData(R.drawable.buyitem,"Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)","5 Colours","US\$10"),
            BuyData(R.drawable.buyitem2,"Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)","5 Colours","US\$10"),
            BuyData(R.drawable.buyitem,"Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)","5 Colours","US\$10"),
            BuyData(R.drawable.buyitem2,"Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)","5 Colours","US\$10")
            )

        val adapter = BuyAdapter(buyList) { item ->
        }
        binding.buyRecyclerView.adapter = adapter
        binding.buyRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

    }
}
