package com.gustavo.findmovies.api.reponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movies(

    @SerializedName("Title")
    @Expose
    val title: String,

    @SerializedName("Year")
    @Expose
    val year: Int,

    @SerializedName("imdbID")
    @Expose
    val imdbID: String,

    @SerializedName("Type")
    val type: String,

    @SerializedName("Poster")
    val poster: String
)