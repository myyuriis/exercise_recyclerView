package com.example.exercise_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_recyclerview.language.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val languageViewModel: LanguageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleview.layoutManager = LinearLayoutManager(this)

        languageViewModel
            .languagesLiveData
            .observe(this, Observer {
                language_recycleview.adapter = LanguageRecycleAdapter(it)
            })
    }

    fun addLanguage(view: View) {
        val languageName: String = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
    }
}