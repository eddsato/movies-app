package com.eddsato.movies.presentation.movielist.usecase

import com.eddsato.movies.repository.movielist.MovieListRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieListUseCaseImpl @Inject constructor(
    private val repository: MovieListRepository
) : MovieListUseCase {

    override suspend fun fetchMovieList(sortOption: String): MovieListUseCaseState.FetchMovieList =
        try {
            val movies = repository.getMovieList(sortOption)
            MovieListUseCaseState.FetchMovieList.DisplayMovieList(movies)
        } catch (exception: HttpException) {
            MovieListUseCaseState.FetchMovieList.DisplayErrors
        } catch (exception: IOException) {
            MovieListUseCaseState.FetchMovieList.DisplayErrors
        }
}
