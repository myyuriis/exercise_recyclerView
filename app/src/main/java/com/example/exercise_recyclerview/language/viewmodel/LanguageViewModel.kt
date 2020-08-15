package com.example.exercise_recyclerview.language.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguageViewModel: ViewModel() {

    val languageList = mutableListOf<String>("Java", "Python")

    val languagesLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String) {
        languageList.add(name)
        languagesLiveData.value = languageList
//        println(languagesLiveData.value?.joinToString())
    }
}