package com.example.mynewmoviesapp.model.repository

import com.example.mynewmoviesapp.model.entites.Actors

interface Repository {
    fun getMoviesFromServer(): Actors
    fun getMoviesFromLocalStorageCategoryOne():List<Actors>
    fun getMoviesFromLocalStorageCategoryTwo():List<Actors>
}