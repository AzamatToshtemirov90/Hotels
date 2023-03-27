package com.azamat.hotelapp.app

import android.content.Context
import androidx.viewbinding.BuildConfig
import com.azamat.hotelapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level

class KoinConfig {
    companion object {
        private val modules = listOf(
            viewModelsModule,
            networkModule,
            repositoryModule,
            apiModule
        )

        fun start(context: Context) {
            startKoin {
                val logLevel = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE
                androidLogger(logLevel)
                androidContext(context)
                modules(modules)
            }
        }

        fun stop() {
            stopKoin()
        }
    }
}