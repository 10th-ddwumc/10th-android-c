package com.yogurt.umc_work02.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogurt.umc_work02.data.model.ItemData
import com.yogurt.umc_work02.data.model.UserData
import com.yogurt.umc_work02.data.model.UserListResponse
import com.yogurt.umc_work02.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

val Context.dataStore by preferencesDataStore(name = "item_preferences")

class ItemDataStore(private val context: Context) {

    val ITEM_DATA_KEY = stringPreferencesKey("item_data")
    val PURCHASE_DATA_KEY = stringPreferencesKey("purchase_data")

    val USER_PROFILE_KEY = stringPreferencesKey("user_profile")
    val USER_LIST_KEY = stringPreferencesKey("user_list")
    private val gson = Gson()

    suspend fun saveItemData(
        key: androidx.datastore.preferences.core.Preferences.Key<String>,
        itemData: List<ItemData>
    ) {
        val itemDataJson = gson.toJson(itemData)
        context.dataStore.edit { preferences ->
            preferences[key] = itemDataJson
        }
    }

    fun getItemDataFlow(key: androidx.datastore.preferences.core.Preferences.Key<String>): kotlinx.coroutines.flow.Flow<List<ItemData>> {
        return context.dataStore.data.map { preferences ->
            val itemDataJson = preferences[key] ?: "[]"
            val type = object : TypeToken<List<ItemData>>() {}.type
            gson.fromJson(itemDataJson, type)
        }
    }

    suspend fun saveUserProfile(user: UserResponse) {
        val userJson = gson.toJson(user)
        context.dataStore.edit { preferences ->
            preferences[USER_PROFILE_KEY] = userJson
        }
    }

    fun getUserProfileFlow(): Flow<UserResponse?> {
        return context.dataStore.data.map { preferences ->
            val userJson = preferences[USER_PROFILE_KEY]

            if (userJson != null) {
                val type = object : TypeToken<UserResponse>() {}.type
                gson.fromJson(userJson, UserResponse::class.java)
            } else {
                null
            }
        }
    }

    suspend fun saveUserList(userList: UserListResponse) {
        val userListJson = gson.toJson(userList)
        context.dataStore.edit { preferences ->
            preferences[USER_LIST_KEY] = userListJson
        }
    }

    fun getUserListFlow(): Flow<UserListResponse?> {
        return context.dataStore.data.map { preferences ->
            val userListJson = preferences[USER_LIST_KEY]
            if (userListJson != null) {
                val type = object : TypeToken<List<UserResponse>>() {}.type
                gson.fromJson(userListJson, UserListResponse::class.java)
            } else {
                null
            }
        }
    }
}
