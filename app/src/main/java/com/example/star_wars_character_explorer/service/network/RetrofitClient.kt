package com.example.star_wars_character_explorer.service.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // Define your BASE_URL here
    val BASE_URL = "https://swapi.dev/api/"


    // Create an OkHttpClient
    val okHttpClient = OkHttpClient.Builder().build()

    // Create a Retrofit instance
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

//    private val apiInterface: ApiInterface = getInstance().create(ApiInterface::class.java)
//
//    fun getApiInterface(): ApiInterface {
//        return apiInterface
//    }

}