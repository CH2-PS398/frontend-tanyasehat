package com.example.diarystoryapp.di

import android.content.Context
import com.example.diarystoryapp.data.Retrofit.APIConfig
import com.example.diarystoryapp.data.local.UserPreference
import com.example.tanyasehatapp.data.repository.UserRepository


object Injection {

    fun provideUserRepository(context: Context): UserRepository {
        val apiService = APIConfig.getAPIService(token = "")
        val userPreference = UserPreference.getInstance(context)
        return UserRepository.getInstance(apiService, userPreference)
    }
}