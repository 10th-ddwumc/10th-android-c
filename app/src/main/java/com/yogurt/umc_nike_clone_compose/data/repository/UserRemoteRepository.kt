package com.yogurt.umc_nike_clone_compose.data.repository

import android.util.Log
import com.yogurt.umc_nike_clone_compose.data.model.UserListResponse
import com.yogurt.umc_nike_clone_compose.data.model.UserResponse
import com.yogurt.umc_nike_clone_compose.data.remote.AuthService
import javax.inject.Inject

class UserRemoteRepository @Inject constructor(
    private val authService: AuthService
) {
    suspend fun getUser(id: Int): Result<UserResponse> {
        return try {
            val response = authService.getUser(id)
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
