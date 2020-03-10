package com.example.overkill.ui.simple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    companion object {
        const val MAGIC_HP: Int = 20
        const val MAGIC_COMM_HP: Int = 20
        const val YUGIOH_HP: Int = 8000
    }

    private val _pHp = MutableLiveData<Int>().apply { value = YUGIOH_HP }

    var playerHealth: LiveData<Int> = _pHp
}