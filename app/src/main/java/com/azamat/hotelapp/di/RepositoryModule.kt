package com.azamat.hotelapp.di

import com.azamat.hotelapp.model.repository.RemoteRepository
import com.azamat.hotelapp.model.repository.RemoteRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<RemoteRepository> { RemoteRepositoryImpl(get()) }
}