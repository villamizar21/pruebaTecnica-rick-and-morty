package com.example.pruebatecnica.data.network

import com.example.pruebatecnica.data.api.ApiService
import com.example.pruebatecnica.data.model.Characters.Characters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(private val api: ApiService) {

    suspend fun getAllCharacters(): Characters {
        return withContext(Dispatchers.IO) {
            api.getCharater()
        }
    }
}