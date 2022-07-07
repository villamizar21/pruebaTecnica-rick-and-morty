package com.example.pruebatecnica.data.api

import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import com.example.pruebatecnica.data.model.Characters.Characters
import com.example.pruebatecnica.utils.Constans
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constans.CHARACTER)
    suspend fun getCharater(): Characters

    @GET(Constans.CHARACTER+"/{id}")
    suspend fun getCharaterId(@Path("id")id:Long): CharacterId
}