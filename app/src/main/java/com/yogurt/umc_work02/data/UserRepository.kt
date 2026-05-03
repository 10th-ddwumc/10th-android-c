package com.yogurt.umc_work02.data

import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import com.yogurt.umc_work02.data.remote.RetrofitClient

class UserRepository {
    private val authService = RetrofitClient.authService

    // 단일 유저 조회
    suspend fun login(id: Int): Result<UserResponse> {
        return try {
            val response = authService.login(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // 유저 리스트 조회
    suspend fun getUserList(page: Int): Result<UserListResponse> {
        return try {
            val response = authService.fetchUserList(page)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}