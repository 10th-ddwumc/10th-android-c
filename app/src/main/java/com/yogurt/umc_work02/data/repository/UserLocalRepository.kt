package com.yogurt.umc_work02.data.repository

import android.util.Log
import com.yogurt.umc_work02.data.local.datastore.ItemDataStore
import com.yogurt.umc_work02.data.model.ItemData
import com.yogurt.umc_work02.data.model.UserData
import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import kotlinx.coroutines.flow.Flow

class UserLocalRepository(private val itemDataStore: ItemDataStore) {
    fun getAllItems(): Flow<List<ItemData>> {
        return itemDataStore.getItemDataFlow(itemDataStore.ITEM_DATA_KEY)
    }

    suspend fun saveAllItems(items: List<ItemData>) {
        itemDataStore.saveItemData(itemDataStore.ITEM_DATA_KEY, items)
    }

    fun getPurchaseItems(): Flow<List<ItemData>> {
        return itemDataStore.getItemDataFlow(itemDataStore.PURCHASE_DATA_KEY)
    }

    suspend fun savePurchaseItems(items: List<ItemData>) {
        itemDataStore.saveItemData(itemDataStore.PURCHASE_DATA_KEY, items)
    }

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