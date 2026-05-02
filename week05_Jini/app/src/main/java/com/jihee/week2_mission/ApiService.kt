package com.jihee.week2_mission

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("api/users/{id}")
    suspend fun getUser(
        @Header("x-api-key") key: String,
        @retrofit2.http.Path("id") id: Int
    ): UserResponse

    @GET("api/users")
    suspend fun getUsers(
        @Header("x-api-key") key: String,
        @Query("page") page: Int
    ): UserListResponse
}