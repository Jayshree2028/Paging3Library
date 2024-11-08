package com.example.paging3lib.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paging3lib.models.Movie
import com.example.paging3lib.models.moviedetails.MovieDetails
import com.example.paging3lib.paging.MoviePagingSource
import com.example.paging3lib.retrofit.MovieAPI
import com.example.paging3lib.utils.Constants
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: MovieAPI) {
  /*  private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    suspend fun getMovies() {
        val result = movieAPI.getAllMovies("Lucifer", 2, Constants.API_KEY)
        Log.d("TAG", "getMovies: " + result.Search)

    }*/

    fun getMovies() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { MoviePagingSource(movieAPI) }
    ).liveData

    suspend fun getMovieDetails(imdbID:String):MovieDetails{
        val movieDetails = movieAPI.getMovieDetails(imdbID,Constants.API_KEY)
        return movieDetails
    }

}