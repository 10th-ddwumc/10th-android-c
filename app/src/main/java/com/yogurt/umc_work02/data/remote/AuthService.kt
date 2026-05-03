package com.yogurt.umc_work02.data.remote

import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthService {
    @GET("api/users/{id}")
    suspend fun login(@Path("id") id: Int): UserResponse

    @GET("api/users")
    suspend fun fetchUserList(@Query("page") page: Int): UserListResponse
}