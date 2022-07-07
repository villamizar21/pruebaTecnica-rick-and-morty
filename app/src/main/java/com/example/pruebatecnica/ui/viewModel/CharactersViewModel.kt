package com.example.pruebatecnica.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.model.Characters.Characters
import com.example.pruebatecnica.domain.CharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase) :
    ViewModel() {

    val results = MutableLiveData<Characters>()
    fun getCharaters(): LiveData<Characters> = results

    private val snackbarMsg = MutableLiveData<String>()
    fun getSnackbarMsg() = snackbarMsg

    private val loaded = MutableLiveData<Boolean>()
    fun isLoaded() = loaded

    suspend fun getCharatersViewModel() {
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer = charactersUseCase()
                results.value = resultServer
            } catch (e: Exception) {
                snackbarMsg.value = e.message
            } finally {
                loaded.value = true
            }
        }
    }
}