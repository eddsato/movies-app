package com.eddsato.movies.repository.movielist.response

import com.google.gson.annotations.SerializedName

data class MovieContainerResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var movieResponse: ArrayList<MovieResponse>,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("total_results")
    var totalResults: Int
)