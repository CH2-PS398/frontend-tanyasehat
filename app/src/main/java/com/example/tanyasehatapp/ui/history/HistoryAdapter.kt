package com.example.tanyasehatapp.ui.history

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.data.doctor.history.HistoryModel
import com.example.tanyasehatapp.ui.chatdoctor.ChatDoctorActivity

class HistoryAdapter (private val context: Context, private val historyList: ArrayList<HistoryModel>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return historyList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val history = historyList[position]
            holder.txtdoctorname.text = history.historydoctorname
            holder.txtkeluhan.text = history.keluhanhistory
            holder.txttanggal.text = history.tanggalhistory
            holder.txtwaktu.text = history.waktuhistory

        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val txtdoctorname: TextView = view.findViewById(R.id.doctorhistoryName)
            val txtkeluhan: TextView = view.findViewById(R.id.doctorhistorykeluhan)
            val txttanggal: TextView = view.findViewById(R.id.tanggal_history)
            val txtwaktu: TextView = view.findViewById(R.id.doctorhistorywaktu)
        }
    }