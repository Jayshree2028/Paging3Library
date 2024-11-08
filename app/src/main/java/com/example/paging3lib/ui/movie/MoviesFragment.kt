package com.example.paging3lib.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3lib.R
import com.example.paging3lib.databinding.FragmentMoviesBinding
import com.example.paging3lib.paging.MoviePagingationAdapter
import com.example.paging3lib.viewmodels.MainViewModel

class MoviesFragment : Fragment() {
    lateinit var binding: FragmentMoviesBinding
    lateinit var rvMovieData : RecyclerView
    lateinit var movieAdapter : MoviePagingationAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        movieAdapter = MoviePagingationAdapter(mainViewModel)
        setRecyclerView()
        mainViewModel.responseData.observe(requireActivity(),{
            movieAdapter.submitData(lifecycle,it)
        })
    }
    private fun setRecyclerView(){
        rvMovieData.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }
    }

}