package com.eddsato.movies.repository.movielist

import com.eddsato.movies.BuildConfig
import com.eddsato.movies.commons.network.MoviesAPI
import com.eddsato.movies.presentation.movielist.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val api: MoviesAPI
) : MovieListRepository {

    override suspend fun getMovieList(
        sortOption: String
    ): ArrayList<MovieModel> {
        val response = withContext(Dispatchers.IO) {
            api.getMovies(
                sortOption,
                BuildConfig.MOVIE_DATABASE_API_KEY,
                1
            )
        }

        return MovieListMapper.convertMovieListResponseToMovieListModel(response.movieResponse)
    }
}
