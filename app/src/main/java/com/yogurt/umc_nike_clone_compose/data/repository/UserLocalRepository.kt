package com.yogurt.umc_nike_clone_compose.data.repository

import android.util.Log
import com.yogurt.umc_nike_clone_compose.data.local.datastore.ItemDataStore
import com.yogurt.umc_nike_clone_compose.data.model.UserListResponse
import com.yogurt.umc_nike_clone_compose.data.model.UserResponse
import kotlinx.coroutines.flow.Flow

class UserLocalRepository(private val itemDataStore: ItemDataStore) {

    fun getUserProfileFlow(): Flow<UserResponse?> {
        return itemDataStore.getUserProfileFlow()
    }

    suspend fun saveUserProfile(user: UserResponse) {
        itemDataStore.saveUserProfile(user)
    }

    fun getUserListFlow(): Flow<UserListResponse?> {
        return itemDataStore.getUserListFlow()
    }

    suspend fun saveUserList(userList: UserListResponse) {
        Log.d("FLOW_TRACE", "[LocalRepo] DataStore에 데이터 캐싱 시작")
        itemDataStore.saveUserList(userList)
    }
}
