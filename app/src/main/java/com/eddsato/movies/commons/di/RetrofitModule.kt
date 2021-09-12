package com.eddsato.movies.commons.di

import com.eddsato.movies.BuildConfig
import com.eddsato.movies.commons.network.MoviesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Provides
    @Singleton
    fun getInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): MoviesAPI =
        retrofit.create(MoviesAPI::class.java)
}
