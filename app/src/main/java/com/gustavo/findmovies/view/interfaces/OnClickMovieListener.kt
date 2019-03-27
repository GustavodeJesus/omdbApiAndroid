package com.gustavo.findmovies.view.interfaces

import com.gustavo.findmovies.api.reponse.Movies


/**
 *  Interface responável pela ação de click no item do Adapter da RecyclerView de Filmes
 * */
interface OnClickMovieListener {
    fun onMovieClicked(movies: Movies)
}