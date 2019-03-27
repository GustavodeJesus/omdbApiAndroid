package com.gustavo.findmovies.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.gustavo.findmovies.data.dao.MovieDao
import com.gustavo.findmovies.data.entity.Movie

class MoviesRepository(private val movieDao: MovieDao) {

    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()


    @WorkerThread
    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }
}