package com.kay.bysykkeldata.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kay.bysykkeldata.data.BySykkelRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class BySykkelViewModel(private val repo: BySykkelRepository): ViewModel() {

    var liveData = MutableLiveData<List<BySykkelUiModel>>()


    fun getInfo() {
        viewModelScope.launch {
            try {
                 var list = repo.getData()
                liveData.postValue(list)
            } catch (e:Exception){

            }
        }
    }
}
