package com.eddsato.movies.repository.movielist

import androidx.paging.PagingData
import com.eddsato.movies.presentation.movielist.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun getMovieList(sortOption: String): Flow<PagingData<MovieModel>>
}
