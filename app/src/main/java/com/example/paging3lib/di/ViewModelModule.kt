package com.example.paging3lib.di

import androidx.lifecycle.ViewModel
import com.example.paging3lib.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {
    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel):ViewModel
}