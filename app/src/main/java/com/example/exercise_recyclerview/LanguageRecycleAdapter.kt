package com.example.exercise_recyclerview

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class LanguageRecycleAdapter(private val languageList: MutableList<String>): RecyclerView.Adapter<LanguageViewHolder>() {

//    lateinit var listener: LanguageViewHolder.CustomClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        println("$position ${languageList[position]}")
        holder.orderNumber.text = position.toString()
        holder.languageName.text = languageList[position]
        holder.itemView.setOnClickListener(holder)
//        holder.itemView.setOnClickListener{
//            listener.onItemClicked(it, position)
//        }
    }
}

class LanguageViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
    val orderNumber: TextView = v.findViewById<TextView>(R.id.order_number)
    val languageName: TextView = v.findViewById<TextView>(R.id.language_name)

    override fun onClick(p0: View?) {
        Toast.makeText(p0?.context, "${languageName.text}", Toast.LENGTH_SHORT).show()
    }

//    interface CustomClickListener {
//        fun onItemClicked(view: View, index: Int)
//    }
}