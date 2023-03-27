package com.azamat.hotelapp.utils

import com.azamat.hotelapp.model.Constants.OkHttp_TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import com.azamat.hotelapp.BuildConfig


class OkHttpClientFactory {
    companion object {
        const val X_RapidAPI_Key = "X-RapidAPI-Key"
        const val X_RapidAPI_Host = "X-RapidAPI-Host"
        const val CONTENT_TYPE = "application/json"

    }


    fun create(): OkHttpClient.Builder = OkHttpClient.Builder().apply {
        connectTimeout(OkHttp_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(OkHttp_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(OkHttp_TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
        addInterceptor(Interceptor { chain ->
            chain.proceed(
                chain.request()
                    .newBuilder()
                    .addHeader("\$limit", "10")
//                    .addHeader("content-type", CONTENT_TYPE)
                    .addHeader(X_RapidAPI_Host, BuildConfig.API_HOST)
                    .addHeader(
                        X_RapidAPI_Key,
                        BuildConfig.API_KEY
                    )
                    .build()
            )
        })
    }
}