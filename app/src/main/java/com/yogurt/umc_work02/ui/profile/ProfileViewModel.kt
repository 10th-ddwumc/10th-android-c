package com.yogurt.umc_work02.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yogurt.umc_work02.data.repository.UserLocalRepository
import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import com.yogurt.umc_work02.data.repository.UserRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor (
    private val remoteRepository: UserRemoteRepository,
    private val localRepository: UserLocalRepository
) : ViewModel() {

    // 단일 유저
    private val _profileResult = MutableLiveData<Result<UserResponse>>()
    val profileResult: LiveData<Result<UserResponse>> = _profileResult

    fun fetchProfile() {
        viewModelScope.launch {
            Log.d("FLOW_TRACE", "[ViewModel] fetchProfile 호출됨")
            val result = remoteRepository.login(1)

            result.onSuccess { response ->
                Log.d("FLOW_TRACE", "[ViewModel] Profile Remote 성공 -> Local 저장 지시")
                localRepository.saveUserProfile(response)
                _profileResult.postValue(Result.success(response))
            }.onFailure { error ->
                Log.d("FLOW_TRACE", "[ViewModel] Profile Remote 실패 -> Local 데이터 조회 시도")
                localRepository.getUserProfileFlow().collect { localData ->
                    if (localData != null) {
                        Log.d("FLOW_TRACE", "[ViewModel] Profile Local 캐시 데이터 발견")
                        _profileResult.postValue(Result.success(localData))
                    } else {
                        Log.d("FLOW_TRACE", "[ViewModel] Profile Local에도 데이터 없음")
                        _profileResult.postValue(Result.failure(error))
                    }
                }
            }
        }
    }

    // 유저 리스트
    private val _userListResult = MutableLiveData<Result<UserListResponse>>()
    val userListResult: LiveData<Result<UserListResponse>> = _userListResult

    fun fetchUserList(page: Int) {
        viewModelScope.launch {
            Log.d("FLOW_TRACE", "[ViewModel] fetchUserList 호출됨")
            val result = remoteRepository.getUserList(page)

            result.onSuccess { response ->
                Log.d("FLOW_TRACE", "[ViewModel] List Remote 성공 -> Local 저장 지시")
                localRepository.saveUserList(response)
                _userListResult.postValue(Result.success(response))
            }.onFailure { error ->
                Log.d("FLOW_TRACE", "[ViewModel] List Remote 실패 -> Local 데이터 조회 시도")
                localRepository.getUserListFlow().collect { localData ->
                    if (localData != null) {
                        Log.d("FLOW_TRACE", "[ViewModel] List Local 캐시 데이터 발견: ${localData.userList.size}명")
                        _userListResult.postValue(Result.success(localData))
                    } else {
                        Log.d("FLOW_TRACE", "[ViewModel] List Local에도 데이터 없음")
                        _userListResult.postValue(Result.failure(error))
                    }
                }
            }
        }
    }
}

