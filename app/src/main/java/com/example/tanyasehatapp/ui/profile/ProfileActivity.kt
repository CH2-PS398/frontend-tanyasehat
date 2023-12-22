package com.example.tanyasehatapp.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.example.mystoryapp.view.welcome.WelcomeViewModel
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.ui.auth.welcome.WelcomeActivity

class ProfileActivity : AppCompatActivity() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnLogout: Button = findViewById(R.id.btnlogout)
            btnLogout.setOnClickListener {
                suspend {
                    viewModel.logout()
                    startActivity(Intent(this@ProfileActivity, WelcomeActivity::class.java))
                    finish()
                }
        }
    }
}