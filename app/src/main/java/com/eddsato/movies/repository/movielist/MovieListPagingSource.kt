package com.eddsato.movies.repository.movielist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eddsato.movies.BuildConfig
import com.eddsato.movies.commons.network.MoviesAPI
import com.eddsato.movies.presentation.movielist.model.MovieModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val MOVIE_API_STARTING_PAGE_INDEX = 1

class MovieListPagingSource @Inject constructor(
    private val api: MoviesAPI,
    private val sortOption: String
) : PagingSource<Int, MovieModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val apiKey = BuildConfig.MOVIE_DATABASE_API_KEY
        val page = params.key ?: MOVIE_API_STARTING_PAGE_INDEX

        return try {
            val data = api.getMovies(
                sortOption,
                apiKey,
                page
            )

            val movies = MovieListMapper.convertMovieListResponseToMovieListModel(data.movieResponse)
            movies.let {
                LoadResult.Page(
                    data = it,
                    prevKey = if (page == MOVIE_API_STARTING_PAGE_INDEX) null else page - 1,
                    nextKey = if (movies.isEmpty()) null else page + 1
                )
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey
        }
    }
}