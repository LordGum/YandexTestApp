package com.example.animeapp.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private const val EXTRA_URL_BASE = "https://kitsu.io/api/edge/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(EXTRA_URL_BASE)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}