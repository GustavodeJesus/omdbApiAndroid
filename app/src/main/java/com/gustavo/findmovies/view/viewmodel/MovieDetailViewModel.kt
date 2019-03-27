package com.gustavo.findmovies.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gustavo.findmovies.api.reponse.MovieDetailResponse
import com.gustavo.findmovies.api.request.ApiMoviesRequest
import com.gustavo.findmovies.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {

    fun getDetailMovie(imdbId: String): MutableLiveData<MovieDetailResponse> {
        val result = MutableLiveData<MovieDetailResponse>()
        ApiService
            .create(ApiMoviesRequest::class.java)
            .getMovieFullDetail("5ffabf33", imdbId)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    result.value = null
                }

                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        result.value = response.body()
                    } else
                        result.value = null
                }

            })

        return result
    }

}