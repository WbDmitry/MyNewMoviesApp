package com.example.mynewmoviesapp.model.rest_entites

data class MovieDTO(
    val id: Int,
    val title: String,
    val overview: String?,
    val poster_path: String?
)