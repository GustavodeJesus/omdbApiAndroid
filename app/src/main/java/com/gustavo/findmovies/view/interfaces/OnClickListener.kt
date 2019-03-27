package com.gustavo.findmovies.view.interfaces

import com.gustavo.findmovies.data.entity.Movie

interface OnClickListener {
    fun onMovieClicked(movie: Movie)
}