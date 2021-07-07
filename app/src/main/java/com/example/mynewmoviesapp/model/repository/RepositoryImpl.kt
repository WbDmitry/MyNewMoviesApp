package com.example.mynewmoviesapp.model.repository

import com.example.mynewmoviesapp.model.MovieLoader
import com.example.mynewmoviesapp.model.entites.Movie

class RepositoryImpl : Repository {
    override fun getMovieFromServer(id: Int): Movie {
        val dto = MovieLoader.loadMovie(id)
        return Movie(
            id = dto?.id ?: 0,
            title = dto?.title ?: "",
            overview = dto?.overview,
            poster_path = dto?.poster_path
        )
    }

    override fun getListNewMoviesFromServer(): List<Movie> {
        val dto = MovieLoader.loadListNewMovies()
        val listMovies = mutableListOf<Movie>()
        dto?.results?.forEach {
            listMovies += Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                poster_path = it.poster_path,
            )
        }
        return listMovies
    }
}