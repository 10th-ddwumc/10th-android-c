package com.yogurt.umc_work02.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yogurt.umc_work02.data.UserRepository
import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {

    // 단일 유저
    private val _profileResult = MutableLiveData<Result<UserResponse>>()
    val profileResult: LiveData<Result<UserResponse>> = _profileResult

    // 유저 리스트
    private val _userListResult = MutableLiveData<Result<UserListResponse>>()
    val userListResult: LiveData<Result<UserListResponse>> = _userListResult

    fun fetchProfile() {
        viewModelScope.launch {
            val result = repository.login(1)
            _profileResult.postValue(result)
        }
    }

    fun fetchUserList(page: Int) {
        viewModelScope.launch {
            val result = repository.getUserList(page)
            _userListResult.postValue(result)
        }
    }
}

class ProfileViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}