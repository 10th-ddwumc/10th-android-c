package dduw.com.mobile.umc_2week_mission.dataStore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import dduw.com.mobile.umc_2week_mission.data.WishData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.wishDataStore by preferencesDataStore(name = "wish_store")
object WishDataStore{
    val gson = Gson()
    val WISH_KEY = stringPreferencesKey("wish_list")

    //저장
    suspend fun saveItems(context: Context, list: List<WishData>){
        val json = gson.toJson(list)

        context.wishDataStore.edit { prefs ->
            prefs[WISH_KEY] = json
        }
    }

    //불러오기
    fun getItems(context: Context): Flow<List<WishData>>{
        return context.wishDataStore.data.map { prefs ->
            val json = prefs[WISH_KEY]?: "[]"
            gson.fromJson(json, Array<WishData>::class.java).toList()
        }
    }
}