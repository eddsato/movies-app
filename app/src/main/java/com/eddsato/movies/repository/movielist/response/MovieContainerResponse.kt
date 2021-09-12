package com.eddsato.movies.repository.movielist.response

import com.google.gson.annotations.SerializedName

data class MovieContainerResponse(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var movieResponse: ArrayList<MovieResponse>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)