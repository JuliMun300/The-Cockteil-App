package com.example.thecockteilapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CockteilViewModel: ViewModel() {

    private val repository = Repository()

    private val livedata = MutableLiveData<MutableList<Cockteil>>()
    private val livedataStatus = MutableLiveData<StatusProgress>()


    val lista: LiveData<MutableList<Cockteil>>
    get() = livedata

    val status: LiveData<StatusProgress>
        get() = livedataStatus

    init {
        viewModelScope.launch {
            livedataStatus.value = StatusProgress.Loading
            livedata.value = repository.GetCockteils()
            livedataStatus.value = StatusProgress.Sucess
        }
    }

}