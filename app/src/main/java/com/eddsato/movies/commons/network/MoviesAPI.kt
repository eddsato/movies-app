package com.eddsato.movies.commons.network

import com.eddsato.movies.repository.movielist.response.MovieContainerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {

    @GET("movie/{sort_option}")
    fun getMovies(
        @Path("sort_option") sortOption: String,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): MovieContainerResponse


}
