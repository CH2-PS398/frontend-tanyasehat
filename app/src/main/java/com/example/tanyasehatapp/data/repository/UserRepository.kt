package com.example.tanyasehatapp.data.repository

import com.example.diarystoryapp.data.Response.SignupResponse
import com.example.diarystoryapp.data.Retrofit.APIService
import com.example.diarystoryapp.data.local.UserPreference
import com.example.tanyasehatapp.data.response.SigninResponse

class UserRepository private constructor(
    private val apiService: APIService,
    private val userPreference: UserPreference
    ) {

    suspend fun register(name: String, email: String, password: String): SignupResponse {
        return apiService.register(name, email, password)
    }

    suspend fun login(email: String, password: String): SigninResponse {
        val response = apiService.login(email, password)
        userPreference.saveToken(response.data?.token!!)
        return response
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(apiService: APIService, userPreference: UserPreference) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService, userPreference)
            }.also { instance = it }
    }
}