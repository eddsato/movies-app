package com.eddsato.movies.presentation.movielist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val id: Int? = null,
    val posterPath: String? = null,
    val title: String? = null,
    val voteAverage: Double? = null
): Parcelable
