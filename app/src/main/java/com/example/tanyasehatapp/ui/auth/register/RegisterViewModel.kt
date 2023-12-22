package com.example.tanyasehatapp.ui.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diarystoryapp.data.Response.Result
import com.example.diarystoryapp.data.Response.SignupResponse
import com.example.tanyasehatapp.data.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: UserRepository) : ViewModel() {

    companion object {
        private const val REGISTER_ERROR_MESSAGE = "Sign Up Failed"
    }

    private val _signupresult = MutableLiveData<Result<SignupResponse>>()
    val signupresult : LiveData<Result<SignupResponse>> get() = _signupresult

    fun register(
        name: String,
        email: String,
        password: String) {
        viewModelScope.launch {
            _signupresult.value = Result.Loading

            try {
                val response = repository.register(name, email, password)
                _signupresult.value = Result.Success(response)
            } catch (e: Exception) {
                _signupresult.value = Result.Error(e.message ?: "Sign Up Failed")
            }
        }
    }
}