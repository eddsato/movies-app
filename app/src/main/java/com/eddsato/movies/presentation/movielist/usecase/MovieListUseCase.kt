package com.eddsato.movies.presentation.movielist.usecase

interface MovieListUseCase {

    suspend fun fetchMovieList(sortOption: String): MovieListUseCaseState.FetchMovieList
}