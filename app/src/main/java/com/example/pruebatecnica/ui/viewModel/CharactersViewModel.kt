package com.example.pruebatecnica.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.data.model.Characters
import com.example.pruebatecnica.domain.CharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase):ViewModel(){

    val results = MutableLiveData<Characters>()
    fun getCharaters(): LiveData<Characters> = results

    suspend fun getCharatersViewModel(){
        viewModelScope.launch {
            try {
                val resultServer = charactersUseCase()
                results.value = resultServer
            } catch (e: Exception) {
                Log.e("","error en el servidor ${e.message}")
            }
        }
    }
}