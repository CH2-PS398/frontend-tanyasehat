package com.example.diarystoryapp.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class UserPreference(private val context: Context) {


    private val firstTime = booleanPreferencesKey("first_time")
    private val dataStore = context.dataStore
    private val tokenKey = stringPreferencesKey("token")

    fun isLoggedIn(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences.contains(tokenKey)
        }
    }

    fun isFirstTime(): Flow<Boolean> {
        return dataStore.data.map {
            it[firstTime] ?: true
        }
    }

    suspend fun setFirstTime(firstTime: Boolean) {
        dataStore.edit {
            it[this.firstTime] = firstTime
        }
    }

    suspend fun getToken(): String? {
        return dataStore.data.map { preferences ->
            preferences[tokenKey]
        }.firstOrNull()
    }

    suspend fun deleteToken() {
        dataStore.edit {
            it[tokenKey] = "null"
        }
    }

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[tokenKey] = token
        }



    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null
        fun getInstance(context: Context): UserPreference {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserPreference(context).also {
                    INSTANCE = it
                }
            }
        }
    }
}