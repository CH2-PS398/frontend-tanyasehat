package com.example.tanyasehatapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.diarystoryapp.ui.UserViewModelFactory
import com.example.diarystoryapp.ui.WelcomeViewModelFactory
import com.example.mystoryapp.view.welcome.WelcomeViewModel
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.databinding.ActivityMainBinding
import com.example.tanyasehatapp.ui.auth.welcome.WelcomeActivity
import com.example.tanyasehatapp.ui.chatbot.ChatbotActivity
import com.example.tanyasehatapp.ui.chatdoctor.ListDoctor
import com.example.tanyasehatapp.ui.history.HistoryActivity
import com.example.tanyasehatapp.ui.profile.ProfileActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModelFactory by lazy {
        UserViewModelFactory.getInstance(this)
    }

    private val welcomeViewModelFactory by lazy {
        WelcomeViewModelFactory.getInstance(this)
    }

    private val viewModel by viewModels<WelcomeViewModel> {
        welcomeViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnGoToListDoctor: Button = findViewById(R.id.btn_consult_doctor)

        btnGoToListDoctor.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListDoctor::class.java))
        }

        val btnGoToChatBot: Button = findViewById(R.id.btn_consult_chatbot)

        btnGoToChatBot.setOnClickListener {
            startActivity(Intent(this@MainActivity, ChatbotActivity::class.java))
        }

        val btnGoToHistory: Button = findViewById(R.id.btn_history)
        btnGoToHistory.setOnClickListener {
            startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
        }

        val btnGoToProfile: Button = findViewById(R.id.btn_profile)
        btnGoToProfile.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isLoggedIn().collect { isLoggedIn ->
                if (!isLoggedIn) {
                    startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
                    finish()
                }
            }
        }
    }
}