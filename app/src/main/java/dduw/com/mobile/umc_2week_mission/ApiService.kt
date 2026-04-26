package dduw.com.mobile.umc_2week_mission

import dduw.com.mobile.umc_2week_mission.data.UserListResponse
import dduw.com.mobile.umc_2week_mission.data.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService{

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: Int,
        @Header("x-api-key") apiKey: String
    ): Response<UserResponse>

    @GET("users")
    suspend fun getUsers(
        @Header("x-api-key") apiKey: String,
        @Query("page") page: Int
    ): Response<UserListResponse>
}