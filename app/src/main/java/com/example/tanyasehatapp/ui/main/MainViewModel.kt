package com.example.tanyasehatapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.diarystoryapp.data.local.UserPreference
import kotlinx.coroutines.flow.Flow

class MainViewModel (
    private val preference: UserPreference
    ) : ViewModel()  {

    fun isLoggedIn(): Flow<Boolean> = preference.isLoggedIn()

}