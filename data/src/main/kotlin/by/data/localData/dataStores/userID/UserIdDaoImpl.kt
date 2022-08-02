package by.data.localData.dataStores.userID

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val STORE_NAME = "USER_ID_STORE_NAME"
private const val USER_ID = "ID"

class UserIdDaoImpl @Inject constructor(
    private val context: Context
) : UserIdDao {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = STORE_NAME)

    private val userID = stringPreferencesKey(USER_ID)

    override suspend fun observeUserId(): Flow<String> =
        context.dataStore.data.map { preferences ->
            preferences[userID] ?: ""
        }

    override suspend fun setUserId(id: String) {
        context.dataStore.edit { preferences ->
            preferences[userID] = id
        }
    }
}
