package dduw.com.mobile.umc_2week_mission

import dduw.com.mobile.umc_2week_mission.data.User
import dduw.com.mobile.umc_2week_mission.data.UserResponse

class UserRepository {

    suspend fun getUser(): UserResponse? {
        val response = RetrofitInstance.api.getUser(
            1,
            "reqres_98616d2f9b6742d593ec65a57bb52df5"
        )
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
        suspend fun getUsers(): List<User> {
            val response = RetrofitInstance.api.getUsers(
                "reqres_98616d2f9b6742d593ec65a57bb52df5",
                1
            )

            if (response.isSuccessful) {
                return response.body()?.data ?: emptyList()
            }
            return emptyList()
        }
    }