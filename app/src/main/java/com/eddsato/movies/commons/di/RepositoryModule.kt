package com.eddsato.movies.commons.di

import com.eddsato.movies.repository.movielist.MovieListRepository
import com.eddsato.movies.repository.movielist.MovieListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieListRepository(impl: MovieListRepositoryImpl): MovieListRepository
}