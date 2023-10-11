package com.example.star_wars_character_explorer.service.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.star_wars_character_explorer.paging.StarShipPagingSource
import com.example.star_wars_character_explorer.service.network.StarWarsApi

import javax.inject.Inject

class StarShipRepository @Inject constructor(private val starWarsApi: StarWarsApi) {

    suspend fun getSingleStarShip(position: Int) = starWarsApi.getSingleStarShip(position)


    fun getStarShip() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {StarShipPagingSource(starWarsApi)}
    ).liveData

}