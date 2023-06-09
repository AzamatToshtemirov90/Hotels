package com.azamat.hotelapp.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.BuildConfig
import com.azamat.hotelapp.utils.LargeBundleDetector

open class LoggingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("onCreate savedInstanceState=${savedInstanceState != null}")
        LargeBundleDetector.check("onCreate", savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("onSaveInstanceState")
        LargeBundleDetector.check("onSaveInstanceState", outState)
    }

    private fun log(message: String){
        if (BuildConfig.DEBUG){
            Log.v(this.javaClass.simpleName, "$message ${hashCode()}")
        }
    }
}