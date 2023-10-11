package com.example.star_wars_character_explorer.service.model

data class Planet(
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val films: List<Any>,
    val gravity: String,
    val name: String,
    val orbital_period: String,
    val population: String,
    val residents: List<String>,
    val rotation_period: String,
    val surface_water: String,
    val terrain: String,
    val url: String
)