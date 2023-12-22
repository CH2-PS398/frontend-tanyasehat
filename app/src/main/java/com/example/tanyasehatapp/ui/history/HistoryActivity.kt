package com.example.tanyasehatapp.ui.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.data.doctor.history.History
import com.example.tanyasehatapp.data.doctor.model.Doctors
import com.example.tanyasehatapp.ui.chatdoctor.ListDoctorAdapter

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val recyclerView: RecyclerView = findViewById(R.id.rv_history)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        val historyList = History.historydummy


        val adapter = HistoryAdapter(this, ArrayList(historyList))
        recyclerView.adapter = adapter

    }
}