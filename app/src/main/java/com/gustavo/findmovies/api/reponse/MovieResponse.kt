package com.gustavo.findmovies.api.reponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("Search")
    @Expose
    val search: List<Movies>
)
