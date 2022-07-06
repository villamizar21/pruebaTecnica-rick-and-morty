package com.example.pruebatecnica.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pruebatecnica.R
import com.example.pruebatecnica.ui.viewModel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        getCharater()
    }

    private fun getCharater() {
        viewModel.let {
            it.getCharaters().observe(this) { result ->
                Log.e("", "pegelo ñero------> ${result}")
            }
        }
    }

    private fun getData() {
        lifecycleScope.launch {
            viewModel.getCharatersViewModel()
        }
    }
}