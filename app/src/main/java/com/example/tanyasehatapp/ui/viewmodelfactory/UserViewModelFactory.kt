package com.example.diarystoryapp.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diarystoryapp.di.Injection
import com.example.tanyasehatapp.data.repository.UserRepository
import com.example.tanyasehatapp.ui.auth.login.LoginViewModel
import com.example.tanyasehatapp.ui.auth.register.RegisterViewModel

class UserViewModelFactory(
    private val repository: UserRepository,
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context) : UserViewModelFactory {
            if (INSTANCE == null) {
                synchronized(UserViewModelFactory::class.java) {
                    INSTANCE = UserViewModelFactory(Injection.provideUserRepository(context))
                }
            }
            return INSTANCE as UserViewModelFactory
        }
    }
}