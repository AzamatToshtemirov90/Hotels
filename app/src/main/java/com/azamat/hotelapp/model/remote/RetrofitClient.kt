package com.azamat.hotelapp.model.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.azamat.hotelapp.BuildConfig


class RetrofitClient(okHttpClient: OkHttpClient.Builder) {
    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient.build())
        .build()
}