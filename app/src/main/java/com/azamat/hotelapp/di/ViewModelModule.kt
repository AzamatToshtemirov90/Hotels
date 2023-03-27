package com.azamat.hotelapp.di

import com.azamat.hotelapp.ui.fragment.hotellist.HotelListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    factory { Dispatchers.IO }
    viewModel { HotelListViewModel(get(), get()) }
}