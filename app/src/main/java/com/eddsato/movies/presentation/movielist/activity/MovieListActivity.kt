package com.eddsato.movies.presentation.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eddsato.movies.databinding.ActivityMovieListBinding

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
    }
}
