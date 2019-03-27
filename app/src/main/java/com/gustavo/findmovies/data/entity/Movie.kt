package com.gustavo.findmovies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(

    @PrimaryKey
    @ColumnInfo(name = "imdbID")
    val imdbID: String,

    @ColumnInfo(name = "year")
    val year: Int,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "Title")
    val title: String,

    @ColumnInfo(name = "poster")
    val poster: String
)