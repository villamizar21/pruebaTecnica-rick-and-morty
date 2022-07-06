package com.example.pruebatecnica.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.model.Characters
import com.example.pruebatecnica.data.model.Result
import com.example.pruebatecnica.databinding.ItemCharactersBinding

class AdapterCharacters() :
    ListAdapter<Result, RecyclerView.ViewHolder>(CharactersDiffCallback()) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_characters, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val characters = getItem(position)
        with(holder as ViewHolder){
            Glide.with(holder.view)
                .load(characters.image)
                .into(binding.moviePoster)
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemCharactersBinding.bind(view)
    }
    class CharactersDiffCallback:DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem

    }
}