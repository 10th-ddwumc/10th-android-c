package dduw.com.mobile.umc_2week_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dduw.com.mobile.umc_2week_mission.adapter.WishAdapter
import dduw.com.mobile.umc_2week_mission.dataStore.WishDataStore
import dduw.com.mobile.umc_2week_mission.databinding.FragmentWishlistBinding
import kotlinx.coroutines.launch

class WishlistFragment : Fragment() {
    private lateinit var binding: FragmentWishlistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WishAdapter(mutableListOf()) { }
        binding.wishRecyclerview.adapter = adapter
        binding.wishRecyclerview.layoutManager = GridLayoutManager(requireContext(), 2)

        //데이터 불러오기
        lifecycleScope.launch {
            WishDataStore.getItems(requireContext()).collect { list ->
                adapter.updateList(list)
            }
        }

    }
}