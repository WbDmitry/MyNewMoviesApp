package com.example.mynewmoviesapp.model

import com.example.mynewmoviesapp.model.entites.Actors

sealed class AppState {
    data class Success (val actors: Actors) : AppState()
    data class Error (val error: Throwable) : AppState()
    object Loading : AppState()
}