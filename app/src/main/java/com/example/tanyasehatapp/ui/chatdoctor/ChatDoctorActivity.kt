package com.example.tanyasehatapp.ui.chatdoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.data.doctor.model.DoctorModel
import com.example.tanyasehatapp.databinding.ActivityChatDoctorBinding
import com.example.tanyasehatapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatDoctorActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_doctor)

        val btnBack : ImageView = findViewById(R.id.btn_back)

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}