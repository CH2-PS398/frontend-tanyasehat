package com.example.tanyasehatapp.ui.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.tanyasehatapp.R

class ChatbotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        val btnBotchatBack : ImageView = findViewById(R.id.btn_botchat_back)

        btnBotchatBack.setOnClickListener {
            onBackPressed()
        }
    }
}