package com.example.paging3lib

import android.app.Application
import com.example.paging3lib.di.ApplicationComponent
import com.example.paging3lib.di.DaggerApplicationComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication:Application() {
   /* lateinit var applicationComponent : ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }*/
}