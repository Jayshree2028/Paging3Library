package com.example.paging3lib.di

import com.example.paging3lib.retrofit.MovieAPI
import com.example.paging3lib.utils.Constants
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /*  @Singleton
      @Provides
      fun provideLogging():OkHttpClient{
          val logging= HttpLoggingInterceptor()
          logging.level=HttpLoggingInterceptor.Level.BODY
          return OkHttpClient.Builder().addInterceptor(logging).build()
      }
      @Singleton
      @Provides
      fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
          return Retrofit.Builder().baseUrl(Constants.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .client(okHttpClient)
              .build()

      }

      @Singleton
      @Provides
      fun provideApi(retrofit: Retrofit): MovieInterface {
          return retrofit.create(MovieInterface::class.java)
      }*/

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieAPI(retrofit: Retrofit):MovieAPI{
        return retrofit.create(MovieAPI::class.java)
    }


}