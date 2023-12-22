package com.example.tanyasehatapp.ui.auth.welcome

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.diarystoryapp.data.local.UserPreference
import com.example.mystoryapp.view.welcome.WelcomeViewModel
import com.example.tanyasehatapp.ui.main.MainActivity
import com.example.tanyasehatapp.databinding.ActivityWelcomeBinding
import com.example.tanyasehatapp.ui.auth.login.LoginActivity
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {

    private val binding: ActivityWelcomeBinding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    private val welcomeViewModel: WelcomeViewModel by viewModels {
        WelcomeViewModel.WelcomeViewModelFactory.getInstance(UserPreference.getInstance(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()

        lifecycleScope.launch {
            welcomeViewModel.isLoggedIn().collect { isLoggedIn ->
                if (isLoggedIn) {
                    startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
        binding.btnWelcome.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            welcomeViewModel.setFirstTime(false)
        }
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}