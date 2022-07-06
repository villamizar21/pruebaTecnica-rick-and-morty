package com.example.pruebatecnica.data.api

import com.example.pruebatecnica.data.model.Characters
import com.example.pruebatecnica.utils.Constans
import retrofit2.http.GET

interface ApiService {
    @GET(Constans.CHARACTER)
    suspend fun getCharater():Characters
}