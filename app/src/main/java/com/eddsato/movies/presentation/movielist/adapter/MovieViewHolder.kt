package com.eddsato.movies.presentation.movielist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.eddsato.movies.R
import com.eddsato.movies.databinding.ViewMovieItemListBinding
import com.eddsato.movies.presentation.movielist.model.MovieModel

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewMovieItemListBinding.bind(view)
    private var movie: MovieModel? = null

    init {
        view.setOnClickListener {
            Toast.makeText(view.context, "Clicked", Toast.LENGTH_LONG).show()
        }
    }

    fun bind(movie: MovieModel) {
        this.movie = movie

        binding.tvMovieTitle.text = movie.title
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_movie_item_list, parent, false)

            return MovieViewHolder(view)
        }
    }
}
