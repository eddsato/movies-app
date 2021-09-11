package com.eddsato.movies.repository.movielist

import com.eddsato.movies.ui.movielist.model.MovieModel

interface MovieListRepository {

    suspend fun getMovieList(): List<MovieModel>
}
