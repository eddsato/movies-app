package com.eddsato.movies.presentation.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.eddsato.movies.databinding.ActivityMovieListBinding
import com.eddsato.movies.presentation.movielist.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding
    private val viewModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
    }
}
