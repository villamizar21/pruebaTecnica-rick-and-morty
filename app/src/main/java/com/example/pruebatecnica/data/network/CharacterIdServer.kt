package com.example.pruebatecnica.data.network

import com.example.pruebatecnica.data.api.ApiService
import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import com.example.pruebatecnica.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterIdServer @Inject constructor(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    ) {

    suspend fun getCharaterId(id: Long): CharacterId {
        return withContext(ioDispatcher) {
            api.getCharaterId(id)
        }
    }
}