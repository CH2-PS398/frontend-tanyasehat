package com.example.tanyasehatapp.ui.profile

import androidx.lifecycle.ViewModel
import com.example.diarystoryapp.data.local.UserPreference

class ProfileViewModel (private val preference: UserPreference
) : ViewModel()  {

    suspend fun logout() {
        preference.deleteToken()
    }
}