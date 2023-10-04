package com.example.star_wars_character_explorer.service.network

import com.example.star_wars_character_explorer.service.model.PeopleResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("people")
    suspend fun getPeopleList(): Call<PeopleResponse>

    @GET("people")
    suspend fun getAllPeople() : Response<PeopleResponse>
}