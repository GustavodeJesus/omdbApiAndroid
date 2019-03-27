package com.gustavo.findmovies.api.reponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

    @SerializedName("Title")
    @Expose
    val title: String,

    @SerializedName("Year")
    @Expose
    val year: String,

    @SerializedName("Plot")
    @Expose
    val plot: String,

    @SerializedName("Poster")
    @Expose
    val poster: String
)