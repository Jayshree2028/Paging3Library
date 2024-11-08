package com.example.paging3lib.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3lib.models.Movie
import com.example.paging3lib.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository):ViewModel(){
//    val responseData : LiveData<List<Movie>>
//        get() = movieRepository.movies


    val responseData : LiveData<PagingData<Movie>> = movieRepository.getMovies().cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            movieRepository.getMovies()
        }
    }

    fun fetchMovieDetails(imdbID: String){
        viewModelScope.launch {
            val movieDetails = movieRepository.getMovieDetails(imdbID)
            Log.d("MainViewModel", "Movie Details: $movieDetails")
        }
    }
}