package com.example.mynewmoviesapp.model.repository

import com.example.mynewmoviesapp.model.entites.Actors

class RepositoryImpl : Repository {
    override fun getMoviesFromServer(): Actors {
        return Actors()
    }

    override fun getMoviesFromLocalStorage(): Actors {
        return Actors()
    }
}