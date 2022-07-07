package com.example.pruebatecnica.ui.view.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.pruebatecnica.data.model.CharacterId.CharacterId
import com.example.pruebatecnica.databinding.ActivityCharacterInfoBinding
import com.example.pruebatecnica.ui.viewModel.CharacterIdViewModel
import com.google.android.material.snackbar.Snackbar
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
                setupViews(result)
            }
            it.getSnackbarMsg().observe(this) { msg ->
                Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
            }
            it.isLoaded().observe(this) { status ->
                if (status)
                    binding.progressBar.visibility = View.GONE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupViews(result: CharacterId) {
        Glide.with(this)
            .asBitmap()
            .load(result.image)
            .into(binding.imageViewBackdropPath)

        binding.name.text = "Name: " + result.name
        binding.species.text = "Specie: " + result.species
        binding.status.text = "Status: " + result.status

    }
}