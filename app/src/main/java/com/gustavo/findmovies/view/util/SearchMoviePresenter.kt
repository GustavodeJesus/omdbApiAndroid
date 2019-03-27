package com.gustavo.findmovies.view.util

import android.util.Log
import com.gustavo.findmovies.api.reponse.Movies
import com.gustavo.findmovies.view.interfaces.SearchMovie
import com.gustavo.findmovies.view.viewmodel.SearchViewModel

class SearchMoviePresenter internal constructor(private val view: SearchMovie.View) :
    SearchMovie.Presenter, SearchMovie.Model.OnMoviesSearchListener {
    private val model: SearchMovie.Model

    private val TAG = SearchMoviePresenter::class.java.simpleName

    init {
        model = SearchViewModel()
    }

    override fun onNoSearchParam() {
        view.showPlate()
    }

    override fun onSearchParam(string: String) {
        model.getSearchResults(this, string)
        view.hidePlate()
    }

    override fun onFinished(movies: List<Movies>) {
        view.showRes(movies)
    }

    override fun onFailure(throwable: Throwable) {
        Log.v(TAG, throwable.localizedMessage)
    }
}
