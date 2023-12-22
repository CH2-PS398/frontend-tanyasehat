package com.example.tanyasehatapp.ui.chatdoctor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.data.doctor.model.DoctorModel
import de.hdodenhof.circleimageview.CircleImageView

class ListDoctorAdapter(private val context: Context, private val doctorList: ArrayList<DoctorModel>) :
    RecyclerView.Adapter<ListDoctorAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = doctorList[position]
        holder.txtUserName.text = doctor.doctorname
        holder.txtSpecialty.text = doctor.doctorspecialty
        holder.txtYearExp.text = doctor.doctoryearexperience
        Glide.with(context).load(doctor.doctorimage).placeholder(R.drawable.dokter_gambar).into(holder.imgdoctor)
        holder.btnChatDoctor.setOnClickListener {
            val intent = Intent(context,ChatDoctorActivity::class.java)

            context.startActivity(intent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtUserName: TextView = view.findViewById(R.id.doctorName)
        val txtSpecialty: TextView = view.findViewById(R.id.specialty)
        val txtYearExp: TextView = view.findViewById(R.id.tv_year_experience)
        val imgdoctor: CircleImageView = view.findViewById(R.id.doctorImage)
        val btnChatDoctor: Button = view.findViewById(R.id.btn_chat_doctor)
    }
}