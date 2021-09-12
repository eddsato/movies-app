package com.eddsato.movies.repository.movielist

import com.eddsato.movies.presentation.movielist.model.MovieModel

interface MovieListRepository {

    suspend fun getMovieList(sortOption: String): ArrayList<MovieModel>
}
