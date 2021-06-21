package com.example.mynewmoviesapp.model.repository

import com.example.mynewmoviesapp.model.entites.Actors
import com.example.mynewmoviesapp.model.entites.getCategoryOne
import com.example.mynewmoviesapp.model.entites.getCategoryTwo

class RepositoryImpl : Repository {
    override fun getMoviesFromServer(): Actors {
        return Actors()
    }

    override fun getMoviesFromLocalStorageCategoryOne() = getCategoryOne()

    override fun getMoviesFromLocalStorageCategoryTwo() = getCategoryTwo()
}