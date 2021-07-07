package com.example.mynewmoviesapp.model

import com.example.mynewmoviesapp.model.entites.Movie

sealed class AppState {
    data class Success(val movie: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}