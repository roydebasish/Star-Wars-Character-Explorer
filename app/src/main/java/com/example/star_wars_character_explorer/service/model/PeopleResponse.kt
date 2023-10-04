package com.example.star_wars_character_explorer.service.model

data class PeopleResponse(
    val count: Int,
    val next: String,
    val previous: Any?,
    val results: List<People>
)