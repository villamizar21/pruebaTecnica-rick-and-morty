package com.example.pruebatecnica.domain

import com.example.pruebatecnica.data.repository.CharactersRepositoy
import com.example.pruebatecnica.data.model.Characters.Characters
import javax.inject.Inject

class CharactersUseCase @Inject constructor(private val repository: CharactersRepositoy){
    suspend operator fun invoke(): Characters {
        return repository.getCharaterFromApi()
    }
}