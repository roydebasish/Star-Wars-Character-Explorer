package com.example.star_wars_character_explorer.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StarShipRemoteKeys")
data class StarShipRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val prevPage: String?,
    val nextPage: String?,
    )
