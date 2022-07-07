package com.example.pruebatecnica.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService


object Constans {
    const val BASE_URL = "https://rickandmortyapi.com/api/"
    const val CHARACTER = "character"

    fun verificationNet(activity: Activity): Boolean {
        val connectivityManager =
            activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val actNetInfo = connectivityManager!!.activeNetworkInfo
        return actNetInfo != null && actNetInfo.isConnected
    }
}