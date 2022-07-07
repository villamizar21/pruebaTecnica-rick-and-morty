package com.example.pruebatecnica.data.network

import com.example.pruebatecnica.data.api.ApiService
import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterIdServer @Inject constructor(private val api: ApiService) {

    suspend fun getCharaterId(id: Long): CharacterId {
        return withContext(Dispatchers.IO) {
            api.getCharaterId(id)
        }
    }
}