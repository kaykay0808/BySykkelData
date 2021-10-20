package com.kay.bysykkeldata.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.bysykkeldata.data.BySykkelRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class BySykkelViewModel(val repo: BySykkelRepository): ViewModel() {
    fun getInfo() {
        viewModelScope.launch {
            try {
                 //livedata for my list
            } catch (e:Exception){
                // livedata for error
            }
            //val test = repo.getData()
            //val test1 = test
        }
    }
}