package com.example.star_wars_character_explorer.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.star_wars_character_explorer.paging.CharacterPagingSource
import com.example.star_wars_character_explorer.service.model.People
import com.example.star_wars_character_explorer.service.network.StarWarsApi

import javax.inject.Inject

class CharacterRepository @Inject constructor(private val starWarsApi: StarWarsApi) {

    suspend fun getSingleCharacter(position: Int) = starWarsApi.getSingleCharacter(position)


    fun getCharacters() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {CharacterPagingSource(starWarsApi)}
    ).liveData


}