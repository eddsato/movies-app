package com.eddsato.movies.repository.movielist.response

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("adult")
    var adult: Boolean,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("genre_ids")
    var genreIds: ArrayList<Int>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("popularity")
    var popularity: Double,
    @SerializedName("vote_count")
    var voteCount: Int,
    @SerializedName("video")
    var video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Double
)