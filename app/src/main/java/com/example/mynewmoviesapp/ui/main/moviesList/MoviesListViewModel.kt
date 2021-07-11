package com.example.mynewmoviesapp.ui.main.moviesList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.repository.Repository
import com.example.mynewmoviesapp.model.repository.RepositoryImpl
import java.lang.Thread.sleep

class MoviesListViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve
    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            try {
                liveDataToObserve.postValue(
                    AppState.Success(
                        repository.getListNewMoviesFromServer()
                    ))
            } catch (ex: Exception) {
                liveDataToObserve.postValue(
                    AppState.Error(
                        error = ex
                    ))
            }
        }.start()
    }
}