package com.azamat.hotelapp.di

import com.azamat.hotelapp.model.remote.RetrofitClient
import com.azamat.hotelapp.utils.OkHttpClientFactory
import com.azamat.hotelapp.utils.ResponseHandler
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient(OkHttpClientFactory().create()).retrofit }
    factory { ResponseHandler() }
}