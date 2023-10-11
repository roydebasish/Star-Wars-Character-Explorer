package com.example.star_wars_character_explorer.service.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.star_wars_character_explorer.paging.PlanetPagingSource
import com.example.star_wars_character_explorer.paging.StarShipPagingSource
import com.example.star_wars_character_explorer.service.network.StarWarsApi

import javax.inject.Inject

class PlanetRepository @Inject constructor(private val starWarsApi: StarWarsApi) {

    suspend fun getSinglePlanet(position: Int) = starWarsApi.getSinglePlanet(position)


    fun getPlanet() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {PlanetPagingSource(starWarsApi)}
    ).liveData

}