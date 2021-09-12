package com.eddsato.movies.presentation.movielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.eddsato.movies.presentation.BaseViewModel
import com.eddsato.movies.presentation.movielist.model.MovieModel
import com.eddsato.movies.presentation.movielist.usecase.MovieListUseCase
import com.eddsato.movies.presentation.movielist.usecase.MovieListUseCaseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor (
    private val useCase: MovieListUseCase
) : BaseViewModel() {
    private val mutableViewState = MutableLiveData<MovieListViewState>()
    val viewState: LiveData<MovieListViewState> = mutableViewState

    fun fetchMovies(sortOption: String) {
        launch {
            mutableViewState.value = MovieListViewState.ShowLoading

            val fetchedMovies = useCase.fetchMovieList(sortOption)
            handleFetchScreen(fetchedMovies)
        }
    }

    private fun handleFetchScreen(result: MovieListUseCaseState.FetchMovieList) {
        when (result) {
            is MovieListUseCaseState.FetchMovieList.DisplayMovieList -> displayMoviesData(result.movieList)
            is MovieListUseCaseState.FetchMovieList.DisplayErrors -> displayError()
        }
    }

    private fun displayMoviesData(movieList: Flow<PagingData<MovieModel>>) {
        mutableViewState.value = MovieListViewState.ShowMovieListData(movieList)
    }

    private fun displayError() {
        mutableViewState.value = MovieListViewState.ShowError
    }
}