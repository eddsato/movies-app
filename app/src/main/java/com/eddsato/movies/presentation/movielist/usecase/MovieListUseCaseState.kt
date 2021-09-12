package com.eddsato.movies.presentation.movielist.usecase

import androidx.paging.PagingData
import com.eddsato.movies.presentation.movielist.model.MovieModel
import kotlinx.coroutines.flow.Flow

object MovieListUseCaseState {

    sealed class FetchMovieList {
        object DisplayErrors : FetchMovieList()
        object EmptyState : FetchMovieList()
        data class DisplayMovieList(val movieList: Flow<PagingData<MovieModel>>) : FetchMovieList()
    }
}
