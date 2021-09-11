package com.eddsato.movies.ui.movielist.usecase

interface MovieListUseCase {

    suspend fun fetchMovieList(): MovieListUseCaseState.FetchMovieList
}