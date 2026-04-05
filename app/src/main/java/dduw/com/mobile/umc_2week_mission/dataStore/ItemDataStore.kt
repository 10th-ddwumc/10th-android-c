package dduw.com.mobile.umc_2week_mission.dataStore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import dduw.com.mobile.umc_2week_mission.data.ItemData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// DataStore 확장
val Context.dataStore by preferencesDataStore(name = "item_store")

object ItemDataStore {

     val gson = Gson()
     val ITEM_KEY = stringPreferencesKey("item_list")

    // 저장
    suspend fun saveItems(context: Context, list: List<ItemData>) {
        val json = gson.toJson(list)

        context.dataStore.edit { prefs ->
            prefs[ITEM_KEY] = json
        }
    }

    // 불러오기
    fun getItems(context: Context): Flow<List<ItemData>> {
        return context.dataStore.data.map { prefs ->
            val json = prefs[ITEM_KEY] ?: "[]"
            gson.fromJson(json, Array<ItemData>::class.java).toList()
        }
    }
}