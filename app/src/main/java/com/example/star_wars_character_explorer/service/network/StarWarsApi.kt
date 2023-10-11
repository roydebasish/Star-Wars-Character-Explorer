package com.example.star_wars_character_explorer.service.network

import androidx.lifecycle.LiveData
import com.example.star_wars_character_explorer.service.model.People
import com.example.star_wars_character_explorer.service.model.PeopleResponse
import com.example.star_wars_character_explorer.service.model.Planet
import com.example.star_wars_character_explorer.service.model.PlanetResponse
import com.example.star_wars_character_explorer.service.model.StarShip
import com.example.star_wars_character_explorer.service.model.StarShipResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApi {


    @GET("people")
    suspend fun getCharecters(@Query("page") page : Int) : PeopleResponse

    @GET("people/{position}")
    suspend fun getSingleCharacter(@Path("position") position : Int) : Response<People>

    @GET("starships")
    suspend fun getStarShips(@Query("page") page : Int) : StarShipResponse


    @GET("starships/{position}")
    suspend fun getSingleStarShip(@Path("position") position : Int) : Response<StarShip>


    @GET("planets")
    suspend fun getPlanets(@Query("page") page : Int) : PlanetResponse


    @GET("planets/{position}")
    suspend fun getSinglePlanet(@Path("position") position : Int) : Response<Planet>

}