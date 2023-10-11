package com.example.star_wars_character_explorer.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "StarShip")
data class StarShip(
    val MGLT: String,
    val cargo_capacity: String,
    val consumables: String,
    val cost_in_credits: String,
    val created: String,
    val crew: String,
    val edited: String,
//    val films: List<String>,
    val hyperdrive_rating: String,
    val length: String,
    val manufacturer: String,
    val max_atmosphering_speed: String,
    val model: String,
//    @PrimaryKey(autoGenerate = false)
    val name: String,
    val passengers: String,
//    val pilots: List<String>,
    val starship_class: String,
    val url: String
)