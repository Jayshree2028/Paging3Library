package com.example.paging3lib.models
data class MovieResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)