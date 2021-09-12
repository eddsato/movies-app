package com.eddsato.movies.presentation.movielist.usecase

import com.eddsato.movies.presentation.movielist.model.MovieModel

object MovieListUseCaseState {

    sealed class FetchMovieList {
        object DisplayErrors : FetchMovieList()
        data class DisplayMovieList(val movieList: List<MovieModel>) : FetchMovieList()
    }
}
