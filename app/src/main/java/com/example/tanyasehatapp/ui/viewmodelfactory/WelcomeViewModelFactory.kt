package com.example.diarystoryapp.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diarystoryapp.data.local.UserPreference
import com.example.mystoryapp.view.welcome.WelcomeViewModel

class WelcomeViewModelFactory(
    private val userPreference: UserPreference
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(WelcomeViewModel::class.java) -> {
                WelcomeViewModel(userPreference) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: WelcomeViewModelFactory? = null

        fun getInstance(context: Context): WelcomeViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                val userPreference = UserPreference.getInstance(context)
                INSTANCE ?: WelcomeViewModelFactory(userPreference)
            }.also { INSTANCE = it }
        }
    }
}