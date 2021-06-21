package com.example.mynewmoviesapp.ui.main.moviesList

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.repository.Repository
import com.example.mynewmoviesapp.model.repository.RepositoryImpl
import java.lang.Thread.sleep

class MoviesListViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveData() = liveDataToObserve
    fun getMoviesFromLocalStorageCategoryOne() = getDataFromLocalSource(isRussian = true)

    fun getMoviesFromLocalStorageCategoryTwo() = getDataFromLocalSource(isRussian = false)

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(
                if (isRussian) repository.getMoviesFromLocalStorageCategoryTwo()
                else repository.getMoviesFromLocalStorageCategoryOne()))
        }.start()
    }
}