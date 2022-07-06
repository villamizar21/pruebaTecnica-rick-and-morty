package com.example.pruebatecnica.data

import com.example.pruebatecnica.data.model.Characters
import com.example.pruebatecnica.data.network.CharacterService
import javax.inject.Inject

class CharactersRepositoy @Inject constructor(private val service: CharacterService) {

    suspend fun getCharaterFromApi(): Characters {
         return service.getAllCharacters()
    }
}