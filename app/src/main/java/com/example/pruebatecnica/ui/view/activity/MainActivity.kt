package com.example.pruebatecnica.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.example.pruebatecnica.ui.view.adapter.AdapterCharacters
import com.example.pruebatecnica.ui.view.interfaceClick.Click
import com.example.pruebatecnica.ui.viewModel.CharactersViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Click {

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
        adapterCharacters = AdapterCharacters(this)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterCharacters
        }
    }

    private fun getCharater() {
        viewModel.let {
            it.getCharaters().observe(this) { result ->
                adapterCharacters.submitList(result.results)
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

    private fun getData() {
        lifecycleScope.launch {
            viewModel.getCharatersViewModel()
        }
    }

    override fun click(id: Long) {

        val intent = Intent(this, CharacterInfo::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_right,R.anim.silde_right_exit)
    }
}