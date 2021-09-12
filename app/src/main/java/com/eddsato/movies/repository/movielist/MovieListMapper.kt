package com.eddsato.movies.repository.movielist

import com.eddsato.movies.repository.movielist.response.MovieResponse
import com.eddsato.movies.presentation.movielist.model.MovieModel

object MovieListMapper {

    fun convertMovieListResponseToMovieListModel(
        response: ArrayList<MovieResponse>?
    ): ArrayList<MovieModel> {
        val movieList = ArrayList<MovieModel>()

        response?.let {
            for (movie in response) {
                val model = setMovieModel(movie)
                movieList.add(model)
            }
        }

        return movieList
    }

    private fun setMovieModel(movieResponse: MovieResponse) = MovieModel(
        id = movieResponse.id,
        title = movieResponse.title,
        posterPath = movieResponse.posterPath,
        voteAverage = movieResponse.voteAverage
    )
}