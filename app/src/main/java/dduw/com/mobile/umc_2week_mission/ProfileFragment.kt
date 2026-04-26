package dduw.com.mobile.umc_2week_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import dduw.com.mobile.umc_2week_mission.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import dduw.com.mobile.umc_2week_mission.adapter.UserAdapter

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 데이터 요청
        viewModel.fetchUser()

        // 데이터 관찰
        lifecycleScope.launch {
            viewModel.user.collect { user ->

                if (user != null) {
                    binding.userName.text =
                        "${user.first_name} ${user.last_name}"

                    Glide.with(requireContext())
                        .load(user.avatar)
                        .into(binding.imageView2)
                }
            }
        }
        val adapter = UserAdapter(emptyList())
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewModel.fetchUsers()

        lifecycleScope.launch {
            viewModel.userList.collect {
                adapter.updateList(it)
            }
        }
    }
}