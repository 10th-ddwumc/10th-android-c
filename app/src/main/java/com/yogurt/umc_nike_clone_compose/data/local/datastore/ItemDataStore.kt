package com.yogurt.umc_nike_clone_compose.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogurt.umc_nike_clone_compose.data.model.UserListResponse
import com.yogurt.umc_nike_clone_compose.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "nike_preferences")

class ItemDataStore(private val context: Context) {

    private val USER_PROFILE_KEY = stringPreferencesKey("user_profile")
    private val USER_LIST_KEY = stringPreferencesKey("user_list")
    private val gson = Gson()

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
                gson.fromJson(userListJson, UserListResponse::class.java)
            } else {
                null
            }
        }
    }
}
