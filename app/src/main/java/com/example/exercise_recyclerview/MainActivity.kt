package com.example.exercise_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_recyclerview.language.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CustomClickListener {

    val languageViewModel: LanguageViewModel by viewModels()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleview.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languagesLiveData.value!!)
        languageRecycleAdapter.listener = this
        language_recycleview.adapter = languageRecycleAdapter

        languageViewModel
            .languagesLiveData
            .observe(this, Observer {
                languageRecycleAdapter.notifyDataSetChanged()
            })
    }

    fun addLanguage(view: View) {
        val languageName: String = language_name_input.text.toString()
        if (languageName.isEmpty()) {
            Toast.makeText(this, "Input cannot be empty!", Toast.LENGTH_SHORT).show()
        } else {
            languageViewModel.addLanguage(languageName)
        }
    }

    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(this, "$language clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(view: View, index: Int, language: String) {
        Toast.makeText(this, "$language deleted!", Toast.LENGTH_SHORT).show()
        languageViewModel.removeLanguage(index)
    }
}