package com.example.tanyasehatapp.ui.chatdoctor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.data.doctor.model.DoctorModel
import com.example.tanyasehatapp.data.doctor.model.Doctors
import com.google.firebase.Firebase

class ListDoctor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_doctor)

        val recyclerView: RecyclerView = findViewById(R.id.rv_list_doctor)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


       val doctorList = Doctors.dummy


        val adapter = ListDoctorAdapter(this, ArrayList(doctorList))
        recyclerView.adapter = adapter

    }
}