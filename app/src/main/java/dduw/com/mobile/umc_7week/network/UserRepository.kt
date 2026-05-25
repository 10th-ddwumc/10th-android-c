package dduw.com.mobile.umc_7week.network
import android.util.Log
import dduw.com.mobile.umc_7week.data.response.User

class UserRepository {

    suspend fun getUser(id: Int): Result<User> = try {

        val response = ApiClient.service.getUser(
            id,
            "reqres_98616d2f9b6742d593ec65a57bb52df5"
        )

        println("응답코드 = ${response.code()}")
        println("응답바디 = ${response.body()}")
        if (response.isSuccessful) {

            val body = response.body()

            if (body == null) {

                Result.failure(Exception("body null"))

            } else {

                Result.success(body.data)
            }

        } else {

            Result.failure(
                Exception("HTTP ${response.code()}")
            )
        }

    } catch (e: Exception) {

        Log.d("API_ERROR", e.toString())

        Result.failure(e)
    }
}