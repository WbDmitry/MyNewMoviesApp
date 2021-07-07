package com.example.mynewmoviesapp.di

import com.example.mynewmoviesapp.model.repository.Repository
import com.example.mynewmoviesapp.model.repository.RepositoryImpl
import com.example.mynewmoviesapp.ui.main.moviesList.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    //View models
    viewModel { MoviesListViewModel(get()) }
}