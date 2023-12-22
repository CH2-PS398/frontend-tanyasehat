package com.example.mystoryapp.view.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.diarystoryapp.data.local.UserPreference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class WelcomeViewModel (private val userPreference: UserPreference) : ViewModel() {

    fun isLoggedIn(): Flow<Boolean> {
        return userPreference.isLoggedIn()
    }

    fun setFirstTime(firstTime: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            userPreference.setFirstTime(firstTime)
        }
    }

    class WelcomeViewModelFactory private constructor(private val userPreference: UserPreference) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
                return WelcomeViewModel(userPreference) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }

        companion object {
            @Volatile
            private var instance: WelcomeViewModelFactory? = null

            fun getInstance(userPreference: UserPreference): WelcomeViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: WelcomeViewModelFactory(userPreference)
                }.also { instance = it }
            }
        }
    }

