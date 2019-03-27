package com.gustavo.findmovies.view.viewmodel

import android.util.Log
import com.gustavo.findmovies.api.reponse.MovieResponse
import com.gustavo.findmovies.api.request.ApiMoviesRequest
import com.gustavo.findmovies.api.service.ApiService
import com.gustavo.findmovies.view.interfaces.SearchMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("SENSELESS_COMPARISON")
class SearchViewModel : SearchMovie.Model {

    private val TAG = SearchViewModel::class.java.simpleName
    private val apiMovies = ApiService.create(ApiMoviesRequest::class.java)

    override fun getSearchResults(
        listener: SearchMovie.Model.OnMoviesSearchListener,
        query: String
    ) {

        val call = apiMovies.getAllMoviesNetwork("5ffabf33", query)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                Log.v(TAG, response.toString())
                if (response.body()!!.search != null) {
                    listener.onFinished(response.body()!!.search)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                listener.onFailure(t)
                Log.d(TAG, t.message)
                t.printStackTrace()
            }
        })
    }
}
