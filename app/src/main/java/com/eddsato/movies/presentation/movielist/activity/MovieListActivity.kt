package com.eddsato.movies.presentation.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.eddsato.movies.databinding.ActivityMovieListBinding
import com.eddsato.movies.presentation.movielist.adapter.MoviesAdapter
import com.eddsato.movies.presentation.movielist.model.MovieModel
import com.eddsato.movies.presentation.movielist.viewmodel.MovieListViewModel
import com.eddsato.movies.presentation.movielist.viewmodel.MovieListViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    private val viewModel: MovieListViewModel by viewModels()
    private val adapter = MoviesAdapter()

    private var movieListJob: Job? = null

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        setupAdapter()
        fetchMovieList()
        initObserver()
    }

    private fun setupAdapter() {
        binding.rvMovieList.adapter = adapter
    }

    private fun fetchMovieList() {
        viewModel.fetchMovies("popular")
    }

    private fun initObserver() {
        viewModel.viewState.observe(this, Observer {
            when (it) {
                is MovieListViewState.ShowMovieListData -> {
                    stopShimmer()
                    showMovieListSuccess(it.movieList)
                }
                is MovieListViewState.ShowLoading -> {
                    starShimmer()
                }
                is MovieListViewState.ShowError -> {
                    stopShimmer()
                    showError()
                }
            }
        })
    }

    private fun showMovieListSuccess(movieList: Flow<PagingData<MovieModel>>) {
        movieListJob?.cancel()
        movieListJob = lifecycleScope.launch {
            movieList.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun starShimmer() {

    }

    private fun stopShimmer() {

    }

    private fun showError() {

    }
}
