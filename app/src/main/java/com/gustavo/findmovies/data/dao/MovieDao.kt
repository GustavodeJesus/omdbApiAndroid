package com.gustavo.findmovies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gustavo.findmovies.data.entity.Movie

@Dao
interface MovieDao {

    @Insert
    fun insert(movie: Movie)

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): LiveData<List<Movie>>
}