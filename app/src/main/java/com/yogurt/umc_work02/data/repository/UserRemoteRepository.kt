package com.yogurt.umc_work02.data.repository

import android.util.Log
import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import com.yogurt.umc_work02.data.remote.AuthService
import com.yogurt.umc_work02.data.remote.RetrofitClient.authService

class UserRemoteRepository (private val authService: AuthService){
    suspend fun login(id: Int): Result<UserResponse> {
        return try {
            val response = authService.login(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserList(page: Int): Result<UserListResponse> {
        Log.d("FLOW_TRACE", "[RemoteRepo] 서버에 유저 리스트 요청 (page: $page)")

        return try {
            val response = authService.fetchUserList(page)
            Log.d("FLOW_TRACE", "[RemoteRepo] 서버 응답 성공: ${response.userList.size}명")
            Result.success(response)
        } catch (e: Exception) {
            Log.e("FLOW_TRACE", "[RemoteRepo] 서버 통신 실패", e)
            Result.failure(e)
        }
    }
}