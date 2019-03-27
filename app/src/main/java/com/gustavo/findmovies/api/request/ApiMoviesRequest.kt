package com.gustavo.findmovies.api.request

import com.gustavo.findmovies.api.reponse.MovieDetailResponse
import com.gustavo.findmovies.api.reponse.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMoviesRequest {

    @GET("/")
    fun getAllMoviesNetwork(
        @Query("apikey") apiKey: String,
        @Query("s") titleMovie: String
    ): Call<MovieResponse>


    @GET("/")
    fun getMovieFullDetail(
        @Query("apikey") apiKey: String,
        @Query("i") imdbID: String
    ): Call<MovieDetailResponse>
}