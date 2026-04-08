package dduw.com.mobile.umc_2week_mission.dataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import dduw.com.mobile.umc_2week_mission.data.BuyData
import dduw.com.mobile.umc_2week_mission.data.ItemData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.buyDataStore by preferencesDataStore(name = "buy_item")

object BuyDataStore{

     val gson = Gson()
     val BUY_KEY = stringPreferencesKey("buy_list")

    //저장
    suspend fun saveItems(context:Context, list: List<BuyData>) {
        val json = gson.toJson(list)

        context.buyDataStore.edit{ prefs ->
            prefs[BUY_KEY] = json
        }
    }

    //불러오기
    fun getItems(context: Context): Flow<List<BuyData>> {
        return context.buyDataStore.data.map { prefs ->
            val json = prefs[BUY_KEY] ?: "[]"
            gson.fromJson(json, Array<BuyData>::class.java).toList()
        }
    }
}