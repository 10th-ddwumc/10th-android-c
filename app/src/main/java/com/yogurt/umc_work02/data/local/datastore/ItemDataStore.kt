package com.yogurt.umc_work02.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogurt.umc_work02.data.model.ItemData
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

val Context.dataStore by preferencesDataStore(name = "item_preferences")

class ItemDataStore(private val context: Context) {

    val ITEM_DATA_KEY = stringPreferencesKey("item_data")
    val PURCHASE_DATA_KEY = stringPreferencesKey("purchase_data")
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
}
