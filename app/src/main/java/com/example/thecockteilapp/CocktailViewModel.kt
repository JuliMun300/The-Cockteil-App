package com.example.thecockteilapp.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecockteilapp.Cocktail
import com.example.thecockteilapp.Repository
import com.example.thecockteilapp.StatusProgress
import kotlinx.coroutines.launch

class CocktailViewModel(private val repository: Repository, private val application: Application) : ViewModel() {


    private val livedataCockteils = MutableLiveData<MutableList<Cocktail>>()
    private val livedataStatus = MutableLiveData<StatusProgress>()

    val lista: LiveData<MutableList<Cocktail>>
    get() = livedataCockteils

    val status: LiveData<StatusProgress>
        get() = livedataStatus

     fun SearchCockteils(query:String){
        try {
            livedataStatus.value = StatusProgress.Loading
            viewModelScope.launch {
                val result = repository.GetCockteils(query)
                livedataCockteils.value = result
                livedataStatus.value = StatusProgress.Sucess

                if(result.isEmpty()){
                    Toast.makeText(application, "Cocktail doesn't exist ", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e:Exception){
            Log.i("Error", "SearchCockteils:Error ")
            livedataStatus.value = StatusProgress.Error
        }

    }
}