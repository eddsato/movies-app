package com.eddsato.movies.repository.movielist

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.eddsato.movies.commons.network.MoviesAPI
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val api: MoviesAPI
) : MovieListRepository {

    override suspend fun getMovieList(
        sortOption: String
    ) = Pager(
        config = PagingConfig(pageSize = RESULT_PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = { MovieListPagingSource(api, sortOption) }
    ).flow

    companion object {
        private const val RESULT_PAGE_SIZE = 20
    }
}
