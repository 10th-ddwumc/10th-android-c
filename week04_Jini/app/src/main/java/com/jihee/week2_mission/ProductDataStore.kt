package com.jihee.week2_mission

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "product_store")

object ProductDataStore {

    private val PRODUCT_LIST = stringPreferencesKey("product_list")
    private val HOME_LIST = stringPreferencesKey("home_list")
    private val WISHLIST = stringPreferencesKey("wishlist")
    private val gson = Gson()

    suspend fun saveProducts(context: Context, list: List<ProductData>) {
        val json = gson.toJson(list)
        context.dataStore.edit {
            it[PRODUCT_LIST] = json
        }
    }

    fun getProducts(context: Context): Flow<List<ProductData>> {
        return context.dataStore.data.map { preferences ->
            val json = preferences[PRODUCT_LIST] ?: ""

            if (json.isEmpty()) {
                emptyList()
            } else {
                gson.fromJson(json, Array<ProductData>::class.java).toList()
            }
        }
    }
    suspend fun saveWishlist(context: Context, list: List<ProductData>) {
        val json = gson.toJson(list)
        context.dataStore.edit {
            it[WISHLIST] = json
        }
    }

    fun getWishlist(context: Context): Flow<List<ProductData>> {
        return context.dataStore.data.map { preferences ->
            val json = preferences[WISHLIST] ?: ""

            if (json.isEmpty()) emptyList()
            else gson.fromJson(json, Array<ProductData>::class.java).toList()
        }
    }

    suspend fun saveHomeProducts(context: Context, list: List<ProductData>) {
        val json = gson.toJson(list)
        context.dataStore.edit {
            it[HOME_LIST] = json
        }
    }

    fun getHomeProducts(context: Context): Flow<List<ProductData>> {
        return context.dataStore.data.map { preferences ->
            val json = preferences[HOME_LIST] ?: ""
            if (json.isEmpty()) emptyList()
            else gson.fromJson(json, Array<ProductData>::class.java).toList()
        }
    }
}