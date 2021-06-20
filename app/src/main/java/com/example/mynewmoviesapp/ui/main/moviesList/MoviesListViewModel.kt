package com.example.mynewmoviesapp.ui.main.moviesList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.repository.Repository
import com.example.mynewmoviesapp.model.repository.RepositoryImpl

class MoviesListViewModel : ViewModel() {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repository: Repository = RepositoryImpl()


    fun getLiveData() = liveDataToObserve

    fun getMovies() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(repository.getMoviesFromLocalStorage())
            )
        }.start()
    }
}