package com.example.pruebatecnica.data.network

import com.example.pruebatecnica.data.api.ApiService
import com.example.pruebatecnica.data.model.Characters.Characters
import com.example.pruebatecnica.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllCharacters(): Characters {
        return withContext(ioDispatcher) {
            api.getCharater()
        }
    }
}