package com.example.tanyasehatapp.ui.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tanyasehatapp.data.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    private val _signinResult = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean>
        get() = _signinResult

        fun login(
            email : String,
            password : String
        ){
            viewModelScope.launch {
                try {
                    val response = repository.login(email, password)
                    _signinResult.postValue(true)
                } catch (e: Exception) {
                    _signinResult.postValue(false)
                }
            }
        }
    }
