package dduw.com.mobile.umc_7week.network

import dduw.com.mobile.umc_7week.data.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ReqresApi {

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: Int,
        @Header("x-api-key") apiKey: String
    ): Response<UserResponse>
}