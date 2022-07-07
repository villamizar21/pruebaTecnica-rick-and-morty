package com.example.pruebatecnica.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

object Constans {
    const val BASE_URL = "https://rickandmortyapi.com/api/"
    const val CHARACTER = "character"

    fun verification(activity: Activity): Boolean {
        val connectivityManager =
            activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.isDefaultNetworkActive
    }

}