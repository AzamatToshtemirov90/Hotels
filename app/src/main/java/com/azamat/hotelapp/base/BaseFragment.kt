package com.azamat.hotelapp.base

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.azamat.hotelapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseFragment : LoggingFragment() {
    protected fun navigate(destinationId: Int, bundle: Bundle? = null) {
        CoroutineScope(Dispatchers.Main).launch {
            findNavController().navigate(
                destinationId,
                bundle,
                getDefaultNavOptions()
            )
        }
    }

    private fun getDefaultNavOptions(): NavOptions? {
        return NavOptions.Builder().apply {
            //here's your animation setup
            setEnterAnim(R.anim.slide_in_right)
            setExitAnim(R.anim.slide_out_left)
            setPopEnterAnim(R.anim.slide_in_left)
            setPopExitAnim(R.anim.slide_out_right)
        }.build()
    }


    open fun onBackPressed() {
        //override in subclass as required
    }

    protected fun popTo(destinationId: Int, inclusive: Boolean = false) {
        CoroutineScope(Dispatchers.Main).launch {
            findNavController().popBackStack(destinationId, inclusive)
        }
    }
}