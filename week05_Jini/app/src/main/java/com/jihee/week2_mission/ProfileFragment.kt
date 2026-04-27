package com.jihee.week2_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jihee.week2_mission.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        adapter = UserAdapter(emptyList())
        binding.followingList.adapter = adapter
        binding.followingList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        loadData()

        return binding.root
    }

    private fun loadData() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getUsers(("reqres_842dfb047c9043af967deb9a16fb3dac"), 1)
                val userList = response.data

                adapter.updateList(userList)

                val userResponse = RetrofitInstance.api.getUser("reqres_842dfb047c9043af967deb9a16fb3dac", 1)
                val me = userResponse.data

                binding.textView.text = "${me.first_name} ${me.last_name}"

                Glide.with(requireContext())
                    .load(me.avatar)
                    .into(binding.imageView2)


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}