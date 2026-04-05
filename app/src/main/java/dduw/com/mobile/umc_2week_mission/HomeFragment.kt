package dduw.com.mobile.umc_2week_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dduw.com.mobile.umc_2week_mission.adapter.ItemAdapter
import dduw.com.mobile.umc_2week_mission.data.ItemData
import dduw.com.mobile.umc_2week_mission.dataStore.ItemDataStore
import dduw.com.mobile.umc_2week_mission.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ItemAdapter(mutableListOf()) { }
        binding.itemRecyclerView.adapter = adapter
        binding.itemRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        //데이터 저장
        lifecycleScope.launch {
            val itemList = listOf(
                ItemData("Air Jordan XXXVI", "US$185", R.drawable.item),
                ItemData("Nike Air Force 1 '07", "US$115", R.drawable.itemsec)
            )
            ItemDataStore.saveItems(requireContext(),itemList)
        }
        //데이터 불러오기
        lifecycleScope.launch{
            ItemDataStore.getItems(requireContext()).collect { list ->
                adapter.updateList(list)
            }
        }
    }


}
