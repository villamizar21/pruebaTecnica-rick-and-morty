package com.example.pruebatecnica.domain

import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import com.example.pruebatecnica.data.repository.CharacterIdRepository
import javax.inject.Inject

class CharacterIdUseCase @Inject constructor(private val repository: CharacterIdRepository){

    suspend operator fun invoke(id: Long):CharacterId{
        return repository.getCharaterFromApi(id)
    }
}