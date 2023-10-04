package com.example.star_wars_character_explorer.service.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.star_wars_character_explorer.service.model.People
import com.example.star_wars_character_explorer.service.model.PeopleResponse
import com.example.star_wars_character_explorer.service.network.ApiInterface
import com.example.star_wars_character_explorer.service.network.RetrofitClient
import com.example.star_wars_character_explorer.viewmodel.CharacterViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarWarsRepository constructor(private val apiInterface: ApiInterface) {

    private var mcontext: Context? = null
    private var instance: StarWarsRepository? = null

    private lateinit var mutableLiveData: MutableLiveData<List<People>>

//    fun getInstance(context: Context?): StarWarsRepository? {
//        if (instance == null) {
//            mcontext = context
//            instance = StarWarsRepository()
//        }
//        return instance
//    }

    suspend fun getAllMovies() = apiInterface.getAllPeople()



}