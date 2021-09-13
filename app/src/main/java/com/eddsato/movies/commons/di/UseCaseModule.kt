package com.eddsato.movies.commons.di

import com.eddsato.movies.presentation.movielist.usecase.MovieListUseCase
import com.eddsato.movies.presentation.movielist.usecase.MovieListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Suppress("unused")
@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindMovieListUseCase(impl: MovieListUseCaseImpl): MovieListUseCase
}