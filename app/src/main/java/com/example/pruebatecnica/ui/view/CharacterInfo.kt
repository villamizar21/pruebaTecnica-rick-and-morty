package com.example.pruebatecnica.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pruebatecnica.databinding.ActivityCharacterInfoBinding
import com.example.pruebatecnica.ui.viewModel.CharacterIdViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterInfo : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterInfoBinding
    private val viewModel: CharacterIdViewModel by viewModels()
    private var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        id = intent.extras?.getLong("id") ?: 0

        lifecycleScope.launch {
            viewModel.getCharaterIdViewModel(id)
        }

        viewModel.let {
            it.getCharaterId().observe(this) { result ->
                Log.e("", "info de el personaje////${result}")
            }
        }
    }

}