package com.eddsato.movies.ui.movielist.usecase

import com.eddsato.movies.ui.movielist.model.MovieModel

object MovieListUseCaseState {

    sealed class FetchMovieList {
        object DisplayErrors : FetchMovieList()
        data class DisplayMovieList(val movieList: List<MovieModel>) : FetchMovieList()
    }
}
