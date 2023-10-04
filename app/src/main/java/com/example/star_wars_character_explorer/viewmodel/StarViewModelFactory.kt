package com.example.star_wars_character_explorer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.star_wars_character_explorer.service.repository.StarWarsRepository

class StarViewModelFactory constructor(private val repository: StarWarsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            CharacterViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}