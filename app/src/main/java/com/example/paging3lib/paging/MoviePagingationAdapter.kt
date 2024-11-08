package com.example.paging3lib.paging

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.paging3lib.databinding.MovieItemsBinding
import com.example.paging3lib.models.Movie
import com.example.paging3lib.ui.details.DetailsFragment
import com.example.paging3lib.viewmodels.MainViewModel

class MoviePagingationAdapter (private val mainViewModel: MainViewModel):
    PagingDataAdapter<Movie, MoviePagingationAdapter.MovieViewHolder>(COMPARATOR) {



    class MovieViewHolder(val movieItemsBinding: MovieItemsBinding) :
        RecyclerView.ViewHolder(movieItemsBinding.root) {


        }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.imdbID == newItem.imdbID
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MoviePagingationAdapter.MovieViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.movieItemsBinding.movieTitle.text = item.Title
            holder.movieItemsBinding.movieYear.text = item.Year
            Glide.with(holder.itemView.context).load(item.Poster)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.movieItemsBinding.movieImage)
        }
        holder.movieItemsBinding.root.setOnClickListener {
            Log.d("TAG", "onBindViewHolder: "+mainViewModel.fetchMovieDetails(item?.imdbID!!))

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val binding = MovieItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)

    }
}