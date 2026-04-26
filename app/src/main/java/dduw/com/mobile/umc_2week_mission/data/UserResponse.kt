package dduw.com.mobile.umc_2week_mission.data

data class UserResponse(
    val data: User
)

data class User(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)