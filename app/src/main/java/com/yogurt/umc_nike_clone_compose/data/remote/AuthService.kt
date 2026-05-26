package com.yogurt.umc_nike_clone_compose.data.remote

import com.yogurt.umc_nike_clone_compose.data.model.UserListResponse
import com.yogurt.umc_nike_clone_compose.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthService {
    @GET("api/users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponse

    @GET("api/users")
    suspend fun fetchUserList(@Query("page") page: Int): UserListResponse
}
