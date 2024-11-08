package com.example.paging3lib.retrofit

import com.example.paging3lib.models.MovieResponse
import com.example.paging3lib.models.moviedetails.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("/")
    suspend fun getAllMovies(
        @Query("s") s: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): MovieResponse

    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey: String
    ): MovieDetails
}