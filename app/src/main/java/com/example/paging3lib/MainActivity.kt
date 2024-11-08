package com.example.paging3lib

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3lib.paging.MoviePagingationAdapter
import com.example.paging3lib.ui.details.DetailsFragment
import com.example.paging3lib.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var rvMovieData :RecyclerView
    lateinit var movieAdapter: MoviePagingationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
//        (application as BaseApplication).applicationComponent.inject(this)
        rvMovieData = findViewById(R.id.rvData)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        movieAdapter = MoviePagingationAdapter(mainViewModel)

        setRecyclerView()
        mainViewModel.responseData.observe(this,{
            movieAdapter.submitData(lifecycle,it)
        })


    }
    private fun setRecyclerView(){
        rvMovieData.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(applicationContext,2)
        }
    }


}