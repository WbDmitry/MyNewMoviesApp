package com.example.mynewmoviesapp.model

import com.example.mynewmoviesapp.model.entites.Actors

sealed class AppState {
    data class Success(val actors: List<Actors>) : AppState()
    data class Error (val error: Throwable) : AppState()
    object Loading : AppState()
}