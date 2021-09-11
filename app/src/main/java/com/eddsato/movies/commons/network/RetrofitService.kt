package com.eddsato.movies.commons.network

import com.eddsato.movies.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    fun getInstance(): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideAPIService(retrofit: Retrofit): MoviesAPI =
        retrofit.create(MoviesAPI::class.java)
}
