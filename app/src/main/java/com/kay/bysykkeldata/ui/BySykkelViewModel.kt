package com.kay.bysykkeldata.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.bysykkeldata.data.BySykkelRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class BySykkelViewModel(private val repo: BySykkelRepository): ViewModel() {

    var liveData = MutableLiveData<List<BySykkelUiModel>>()
    var errorLiveData = MutableLiveData<String?>()


    fun getInfo() {
        viewModelScope.launch {
            try {
                 val list = repo.getData()
                liveData.postValue(list)
                errorLiveData.postValue(null)
            } catch (e:Exception){
                errorLiveData.postValue("error")
            }
        }
    }
}
