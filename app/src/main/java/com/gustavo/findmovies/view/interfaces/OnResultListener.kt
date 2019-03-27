package com.gustavo.findmovies.view.interfaces

import com.gustavo.findmovies.data.entity.Movie
import java.lang.Exception

interface OnResultListener {

    fun onSuccess(movie: Movie)

    fun onFailure(e: Exception)
}