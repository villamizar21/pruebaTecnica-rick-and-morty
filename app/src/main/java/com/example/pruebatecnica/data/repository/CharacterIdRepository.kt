package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import com.example.pruebatecnica.data.network.CharacterIdServer
import javax.inject.Inject

class CharacterIdRepository @Inject constructor(private val service: CharacterIdServer) {

    suspend fun getCharaterFromApi(id: Long): CharacterId {
        return service.getCharaterId(id)
    }
}