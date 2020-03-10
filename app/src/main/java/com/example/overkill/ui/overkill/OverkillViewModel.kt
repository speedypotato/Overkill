package com.example.overkill.ui.overkill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OverkillViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This feature isn't available yet.  Check back later!"
    }
    val text: LiveData<String> = _text
}