package com.example.exercise_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var languageList = mutableListOf<String>("Java", "Python", "C", "C++", "C#", "Objective C", "Golang", "Cobol", "Assembly", "Javascript", "Dart", "Swift")
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleview.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageList)
        language_recycleview.adapter = languageRecycleAdapter
    }

    fun addLanguage(view: View) {
        val languageName: String = language_name_input.text.toString()
        languageList.add(languageName)
        language_recycleview.adapter?.notifyDataSetChanged()
    }
}