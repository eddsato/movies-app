package com.eddsato.movies.presentation.movielist.viewmodel

import androidx.paging.PagingData
import com.eddsato.movies.presentation.movielist.model.MovieModel
import kotlinx.coroutines.flow.Flow

sealed class MovieListViewState {

    object ShowLoading: MovieListViewState()
    object ShowError: MovieListViewState()
    data class ShowMovieListData(val movieList: Flow<PagingData<MovieModel>>): MovieListViewState()
}