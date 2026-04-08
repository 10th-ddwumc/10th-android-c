package dduw.com.mobile.umc_2week_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
}
