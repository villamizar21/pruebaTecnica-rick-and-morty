package com.example.pruebatecnica.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.example.pruebatecnica.ui.view.adapter.AdapterCharacters
import com.example.pruebatecnica.ui.viewModel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharactersViewModel by viewModels()
    private lateinit var adapterCharacters: AdapterCharacters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        getCharater()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapterCharacters = AdapterCharacters()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterCharacters
        }
    }

    private fun getCharater() {
        viewModel.let {
            it.getCharaters().observe(this) { result ->
                Log.e("", "pegelo ñero------> ${result}")
                adapterCharacters.submitList(result.results)
            }
        }
    }

    private fun getData() {
        lifecycleScope.launch {
            viewModel.getCharatersViewModel()
        }
    }
}