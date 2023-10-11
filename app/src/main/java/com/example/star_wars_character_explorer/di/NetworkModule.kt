package com.example.star_wars_character_explorer.di

import com.example.star_wars_character_explorer.service.network.StarWarsApi
import com.example.star_wars_character_explorer.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getStarWarsApi(retrofit: Retrofit) : StarWarsApi {
        return retrofit.create(StarWarsApi::class.java)
    }

}