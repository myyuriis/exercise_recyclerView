package com.example.exercise_recyclerview

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LanguageRecycleAdapter(private val languageList: MutableList<String>): RecyclerView.Adapter<LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.orderNumber.text = position.toString()
        holder.languageName.text = languageList[position]
    }
}

class LanguageViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val orderNumber: TextView = v.findViewById<TextView>(R.id.order_number)
    val languageName: TextView = v.findViewById<TextView>(R.id.language_name)
}