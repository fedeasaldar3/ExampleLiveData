package com.example.examplelivedata.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val sum: MutableLiveData<Int> = MutableLiveData()
    val sumDone: LiveData<Int> = sum

    fun doSume(number1: Int, number2: Int) {
        sum.value = number1 + number2
    }
    // TODO: Implement the ViewModel
}