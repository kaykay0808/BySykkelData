package com.kay.bysykkeldata.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.bysykkeldata.data.BySykkelRepository
import kotlinx.coroutines.launch

class BySykkelViewModel(val repo: BySykkelRepository): ViewModel() {
    fun getInfo() {
        viewModelScope.launch {
            val test = repo.getData()
            val test1 = test

        }
    }
}