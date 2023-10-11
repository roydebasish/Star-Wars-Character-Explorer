package com.example.star_wars_character_explorer.service.model

data class PlanetResponse(
    val count: Int,
    val next: Any?,
    val previous: String,
    val results: List<Planet>
)