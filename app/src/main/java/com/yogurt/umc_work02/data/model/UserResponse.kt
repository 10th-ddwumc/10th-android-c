package com.yogurt.umc_work02.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val userData: UserData
)

data class UserListResponse(
    @SerializedName("data")
    val userList: List<UserData>
)
data class UserData (
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)