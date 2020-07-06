package com.example.firt_kt.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firt_kt.Model.rec_model
import com.example.firt_kt.R

class recy_adapter(val model: ArrayList<rec_model>) : RecyclerView.Adapter<recy_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_file,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
       return model.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(model[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(model_a: rec_model) {

            val  tvName= itemView.findViewById<TextView>(R.id.tv_name)
            val  tvPass = itemView.findViewById<TextView>(R.id.tv_email)
            tvName.text=model_a.name
            tvPass.text=model_a.pass

        }
    }


}