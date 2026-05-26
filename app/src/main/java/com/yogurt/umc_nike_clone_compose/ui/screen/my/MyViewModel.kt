package com.yogurt.umc_nike_clone_compose.ui.screen.my

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogurt.umc_nike_clone_compose.data.model.UserListResponse
import com.yogurt.umc_nike_clone_compose.data.model.UserResponse
import com.yogurt.umc_nike_clone_compose.data.repository.UserLocalRepository
import com.yogurt.umc_nike_clone_compose.data.repository.UserRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val remoteRepository: UserRemoteRepository,
    private val localRepository: UserLocalRepository
) : ViewModel() {

    private val _profileResult = MutableStateFlow<Result<UserResponse>?>(null)
    val profileResult: StateFlow<Result<UserResponse>?> = _profileResult.asStateFlow()

    private val _userListResult = MutableStateFlow<Result<UserListResponse>?>(null)
    val userListResult: StateFlow<Result<UserListResponse>?> = _userListResult.asStateFlow()

    init {
        fetchProfile()
        fetchUserList(2)
    }

    fun fetchProfile() {
        viewModelScope.launch {
            Log.d("FLOW_TRACE", "[ViewModel] fetchProfile 호출됨")
            val result = remoteRepository.getUser(1)

            result.onSuccess { response ->
                Log.d("FLOW_TRACE", "[ViewModel] Profile Remote 성공 -> Local 저장 지시")
                localRepository.saveUserProfile(response)
                _profileResult.value = Result.success(response)
            }.onFailure { error ->
                Log.d("FLOW_TRACE", "[ViewModel] Profile Remote 실패 -> Local 데이터 조회 시도")
                localRepository.getUserProfileFlow().collect { localData ->
                    if (localData != null) {
                        Log.d("FLOW_TRACE", "[ViewModel] Profile Local 캐시 데이터 발견")
                        _profileResult.value = Result.success(localData)
                    } else {
                        Log.d("FLOW_TRACE", "[ViewModel] Profile Local에도 데이터 없음")
                        _profileResult.value = Result.failure(error)
                    }
                }
            }
        }
    }

    fun fetchUserList(page: Int) {
        viewModelScope.launch {
            Log.d("FLOW_TRACE", "[ViewModel] fetchUserList 호출됨")
            val result = remoteRepository.getUserList(page)

            result.onSuccess { response ->
                Log.d("FLOW_TRACE", "[ViewModel] List Remote 성공 -> Local 저장 지시")
                localRepository.saveUserList(response)
                _userListResult.value = Result.success(response)
            }.onFailure { error ->
                Log.d("FLOW_TRACE", "[ViewModel] List Remote 실패 -> Local 데이터 조회 시도")
                localRepository.getUserListFlow().collect { localData ->
                    if (localData != null) {
                        Log.d("FLOW_TRACE", "[ViewModel] List Local 캐시 데이터 발견")
                        _userListResult.value = Result.success(localData)
                    } else {
                        Log.d("FLOW_TRACE", "[ViewModel] List Local에도 데이터 없음")
                        _userListResult.value = Result.failure(error)
                    }
                }
            }
        }
    }
}
