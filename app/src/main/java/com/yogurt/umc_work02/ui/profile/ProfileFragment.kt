package com.yogurt.umc_work02.ui.profile

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.yogurt.umc_work02.R
import com.yogurt.umc_work02.data.UserRepository
import com.yogurt.umc_work02.data.remote.RetrofitClient
import com.yogurt.umc_work02.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory(UserRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val line1 = "나이키 멤버 혜택\n"
        val line2 = "0개 사용가능"
        val builder = SpannableStringBuilder(line1 + line2)
        val colorBlack = ContextCompat.getColor(requireContext(), R.color.black)
        val colorGray = ContextCompat.getColor(requireContext(), R.color.gray_600)


        builder.setSpan(
            AbsoluteSizeSpan(16, true), // 크기
            0, line1.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(
            ForegroundColorSpan(colorBlack), // 색상
            0, line1.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(
            StyleSpan(Typeface.BOLD), // 굵기
            0, line1.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        builder.setSpan(
            AbsoluteSizeSpan(12, true),
            line1.length, builder.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(
            ForegroundColorSpan(colorGray),
            line1.length, builder.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvMembership.text = builder

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvFollowing.layoutManager = layoutManager

        val adapter = FollowingAdapter(emptyList())
        binding.rvFollowing.adapter = adapter

        viewModel.userListResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess { data ->
                val userList = data.userList
                adapter.updateData(userList)
            }.onFailure { error ->
                Log.e("API", "유저 리스트 로드 실패", error)
            }
        }
        observeProfile()
        viewModel.fetchUserList(2)
        performFetchProfile()
    }
    private fun observeProfile() {
        viewModel.profileResult.observe(viewLifecycleOwner) { result ->

            result.onSuccess { data ->
                val user = data.userData

                Log.d("ProfileFragment", "프로필 조회 성공: ${user.firstName}")

                binding.tvName.text = "${user.firstName} ${user.lastName}"

                Glide.with(this)
                    .load(user.avatar)
                    .circleCrop()
                    .into(binding.ivProfile)

            }.onFailure { error ->
                val message = error.message ?: "오류가 발생했습니다."
                Log.d("ProfileFragment", "프로필 로드 실패: $message")
                Toast.makeText(context, "데이터를 불러오지 못했습니다: $message", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun performFetchProfile() {
        viewModel.fetchProfile()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}