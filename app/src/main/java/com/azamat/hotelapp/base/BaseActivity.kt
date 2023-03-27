package com.azamat.hotelapp.base

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.azamat.hotelapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseActivity : LoggingActivity() {

    protected lateinit var navController: NavController

    protected fun initializeNavController(fragmentContainerId: Int) {
        navController =
            supportFragmentManager.findFragmentById(fragmentContainerId)?.findNavController()!!
    }

    protected fun navigate(destinationId: Int, bundle: Bundle? = null) {
        CoroutineScope(Dispatchers.Main).launch {
            navController.navigate(
                destinationId,
                bundle,
                getDefaultNavOptions()
            )
        }
    }

    private fun getDefaultNavOptions(): NavOptions {
        return NavOptions.Builder().apply {
            setEnterAnim(R.anim.slide_in_right)
            setExitAnim(R.anim.slide_out_left)
            setPopEnterAnim(R.anim.slide_in_left)
            setPopExitAnim(R.anim.slide_out_right)
        }.build()
    }

}