package com.azamat.hotelapp.app

import android.app.Application

class HotelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinConfig.start(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        KoinConfig.stop()
    }


}