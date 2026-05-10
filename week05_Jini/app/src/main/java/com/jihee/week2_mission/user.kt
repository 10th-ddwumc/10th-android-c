package com.jihee.week2_mission

data class UserResponse(
    val data: User
)

data class User(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val avatar: String
)

data class UserListResponse(
    val data: List<User>
)