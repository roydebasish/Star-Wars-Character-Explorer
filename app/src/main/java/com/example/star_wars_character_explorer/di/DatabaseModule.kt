package com.example.star_wars_character_explorer.di

import android.content.Context
import androidx.room.Room
import com.example.star_wars_character_explorer.db.StarWarsDatabse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context) : StarWarsDatabse{
        return Room.databaseBuilder(context,StarWarsDatabse::class.java,"starwarsDB").build()
    }
}