package com.example.mynewmoviesapp.model.repository

import com.example.mynewmoviesapp.model.entites.Movie

interface Repository {
    fun getMovieFromServer(id: Int): Movie
    fun getListNewMoviesFromServer(): List<Movie>
}