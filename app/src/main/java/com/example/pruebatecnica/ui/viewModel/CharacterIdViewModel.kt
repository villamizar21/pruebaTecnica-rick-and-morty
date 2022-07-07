package com.example.pruebatecnica.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import com.example.pruebatecnica.domain.CharacterIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterIdViewModel @Inject constructor(private val characterIdUseCase: CharacterIdUseCase) :
    ViewModel() {

    val result = MutableLiveData<CharacterId>()
    fun getCharaterId(): LiveData<CharacterId> = result

    suspend fun getCharaterIdViewModel(id: Long) {
        viewModelScope.launch {
            try {
                val resultServer = characterIdUseCase.invoke(id)
                result.value = resultServer
            } catch (e: Exception) {
                Log.e("","error en el servidor ${e.message}")
            }
        }
    }
}