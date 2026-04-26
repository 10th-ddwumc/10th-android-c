package com.jihee.week2_mission

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("api/users/1")
    suspend fun getUser(
        @Header("x-api-key") key: String
    ): UserResponse

    @GET("api/users")
    suspend fun getUsers(
        @Header("x-api-key") key: String,
        @Query("page") page: Int
    ): UserListResponse
}